package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

	@GetMapping("healthcheck")
	public String helathcheck() {
		return "Ok"; 
	}
	
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
	
	@PostMapping 
	public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) {
		
		try {
			myEntry.setLdate(LocalDateTime.now());
			journalEntryService.saveEntry(myEntry);
			return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
		}
		catch(Exception ex) { 
			return new ResponseEntity<>(myEntry, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping 
	public ResponseEntity<JournalEntry> updateEntry(@RequestBody JournalEntry updatedEntry) {
		JournalEntry loldEntry = journalEntryService.getJournalEntryById(updatedEntry.getId()).orElse(null); 
		
		if(loldEntry != null) { 
			loldEntry.setTitle(updatedEntry.getTitle() != null && !updatedEntry.getTitle().equals("") ? updatedEntry.getTitle() : loldEntry.getTitle());
			loldEntry.setContent(updatedEntry.getContent() != null && !updatedEntry.getContent().equals("") ? updatedEntry.getContent() : loldEntry.getContent());
			journalEntryService.saveEntry(loldEntry);
			return new ResponseEntity<>(loldEntry, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("id/{journalId}")
	public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId journalId) {
		journalEntryService.deleteJournalEntryById(journalId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

