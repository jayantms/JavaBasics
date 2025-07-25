package com.example.demo.controller;

import com.example.demo.api.response.WeatherResponse;
import com.example.demo.service.CacheService;
import com.example.demo.service.UserService;
import com.example.demo.entity.*;
import com.example.demo.service.WeatherService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private WeatherService weatherService;

	@Autowired
	private CacheService cacheService;

	@Autowired
	private RedisTemplate redisTemplate;

	@GetMapping
	public List<User> getAll() {
		return userService.getAllEntries();
	}

	@GetMapping("/{userName}")
	public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
		
		User userInfo = userService.getUserByUserName(userName);
		
		if(userInfo != null ) {
			return new ResponseEntity<>(userInfo, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping 
	public ResponseEntity<User> createEntry(@RequestBody User userInfo) {
		try {
			userService.saveEntry(userInfo);
			return new ResponseEntity<>(userInfo, HttpStatus.CREATED);
		}
		catch(Exception ex) { 
			return new ResponseEntity<>(userInfo, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{userName}")
	public ResponseEntity<User> updateUser(@RequestBody User updatedEntry, @PathVariable String userName) {
		User loldEntry = userService.getUserByUserName(userName);

		if( loldEntry != null ) {
			loldEntry.setUserName(updatedEntry.getUserName() != null && !updatedEntry.getUserName().equals("") ? updatedEntry.getUserName() : loldEntry.getUserName());
			loldEntry.setPassword(updatedEntry.getPassword() != null && !updatedEntry.getPassword().equals("") ? updatedEntry.getPassword() : loldEntry.getPassword());
			userService.saveEntry(loldEntry);
			return new ResponseEntity<>(loldEntry, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("id/{userId}")
	public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId userId) {
		userService.deleteUserById(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


	@GetMapping("/greetings")
	public ResponseEntity<?> greetings() {
		Object lweatherResponse = redisTemplate.opsForValue().get("Pune");


		WeatherResponse weatherResponse = weatherService.getWeather("Pune");
		String greetings = "";
		if(weatherResponse != null) {
			greetings = " " + weatherResponse.getCurrent().getFeelslike();
		}
		return new ResponseEntity<>( "Feels like - "+greetings, HttpStatus.OK);
	}

	@GetMapping("clearcache")
	public void clearCache() {
		cacheService.init();
	}

	////////////////////////

	@PostMapping("/weather/{cityName}")
	public ResponseEntity<?> greetings(@PathVariable String cityName) {

		return new ResponseEntity<>( "Hello from "+cityName, HttpStatus.OK);
	}


}

