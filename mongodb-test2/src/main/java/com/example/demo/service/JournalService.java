package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.JournalEntry;
import com.example.demo.repo.JournalEntryRepo;

@Component 
public class JournalService {

	@Autowired
	private JournalEntryRepo journalRepo; 
	
	public void saveEntry(JournalEntry ljournalEntry ) { 
		journalRepo.save(ljournalEntry);
	}

	public List<JournalEntry> getAllEntries() { 
		return journalRepo.findAll(); 
	}
	
	public Optional<JournalEntry> getJournalEntryById(ObjectId lid) { 
		return journalRepo.findById(lid); 
	}
	
	public void deleteJournalEntryById(ObjectId lid) {
		journalRepo.deleteById(lid);
	}
}
