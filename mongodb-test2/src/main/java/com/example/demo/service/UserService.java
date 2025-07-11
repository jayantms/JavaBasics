package com.example.demo.service;

import com.example.demo.entity.JournalEntry;
import com.example.demo.entity.User;
import com.example.demo.repo.JournalEntryRepo;
import com.example.demo.repo.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component 
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public void saveEntry(User userinfo ) {
		userRepo.save(userinfo);
	}

	public List<User> getAllEntries() {
		return userRepo.findAll();
	}
	
	public User getUserByUserName(String luserName) {
		return userRepo.findByUserName(luserName);
	}
	
	public void deleteUserById(ObjectId lid) {
		userRepo.deleteById(lid);
	}
}
