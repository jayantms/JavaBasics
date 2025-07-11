package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.JournalEntry;
import com.example.demo.repo.JournalEntryRepo;
import org.springframework.transaction.annotation.Transactional;

@Component 
public class JournalService {

	@Autowired
	private JournalEntryRepo journalRepo;

	@Autowired
	private UserService userService;

	@Transactional
	public void saveEntry(JournalEntry ljournalEntry, String userName ) {
		try {
			ljournalEntry.setLdate(LocalDateTime.now());
			User luser = userService.getUserByUserName(userName);
			JournalEntry lsavedEntry = journalRepo.save(ljournalEntry);
			luser.getJournalEntryList().add(lsavedEntry);
			userService.saveEntry(luser);
		}catch(Exception ex) {
			System.out.println(ex);
			throw new RuntimeException("An error occured while trying to save the entry", ex);
		}
	}

	public void saveEntry(JournalEntry ljournalEntry ) {

		ljournalEntry.setLdate(LocalDateTime.now());
		journalRepo.save(ljournalEntry);
	}

	public List<JournalEntry> getAllEntries() { 
		return journalRepo.findAll(); 
	}
	
	public Optional<JournalEntry> getJournalEntryById(ObjectId lid) { 
		return journalRepo.findById(lid); 
	}
	
	public void deleteJournalEntryById(String userName, ObjectId lid) {
		User luser = userService.getUserByUserName(userName);
		luser.getJournalEntryList().removeIf(iter -> iter.getId().equals(lid));
		userService.saveEntry(luser);
		journalRepo.deleteById(lid);
	}
}
