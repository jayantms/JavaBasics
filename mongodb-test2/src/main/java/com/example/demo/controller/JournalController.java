package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.JournalEntry;
import com.example.demo.service.JournalService;

@RestController
@RequestMapping("/Journal")
public class JournalController {
	
	@Autowired
	private JournalService journalEntryService;

	@Autowired
	private UserService userService;

	@GetMapping("healthcheck")
	public String helathcheck() {
		return "Ok"; 
	}

	@GetMapping("/{userName}")
	public ResponseEntity<List<JournalEntry>> getJournalEntriesByUserName(@PathVariable String userName) {

		User luser = userService.getUserByUserName(userName);
		List<JournalEntry> lJournalEntries = luser.getJournalEntryList();

		if(lJournalEntries != null && !lJournalEntries.isEmpty()) {
			return new ResponseEntity<>(luser.getJournalEntryList(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("{userName}")
	public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry, @PathVariable String userName ) {

		try {
			journalEntryService.saveEntry(myEntry, userName);
			return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			System.out.println(ex);
			return new ResponseEntity<>(myEntry, HttpStatus.BAD_REQUEST);
		}
	}


	@DeleteMapping("id/{userName}/{journalId}")
	public ResponseEntity<?> deleteJournalEntryById(@PathVariable String userName, @PathVariable ObjectId journalId) {
		journalEntryService.deleteJournalEntryById(userName, journalId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


	@PutMapping("id/{userName}/{journalId}")
	public ResponseEntity<JournalEntry> updateEntry(@PathVariable String userName, @RequestBody JournalEntry updatedEntry) {
		JournalEntry loldEntry = journalEntryService.getJournalEntryById(updatedEntry.getId()).orElse(null);

		if(loldEntry != null) {
			loldEntry.setTitle(updatedEntry.getTitle() != null && !updatedEntry.getTitle().equals("") ? updatedEntry.getTitle() : loldEntry.getTitle());
			loldEntry.setContent(updatedEntry.getContent() != null && !updatedEntry.getContent().equals("") ? updatedEntry.getContent() : loldEntry.getContent());
			journalEntryService.saveEntry(loldEntry);
			return new ResponseEntity<>(loldEntry, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	/*
	@GetMapping
	public List<JournalEntry> getAll() {
		return journalEntryService.getAllEntries(); 
	}

	@GetMapping("id/{journalId}")
	public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId journalId) {
		
		Optional<JournalEntry> lJournalEntry = journalEntryService.getJournalEntryById(journalId); 
		
		if(lJournalEntry.isPresent()) {
			return new ResponseEntity<>(lJournalEntry.get(), HttpStatus.OK); 
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	


	*/
}

