package com.kf2y.tcool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kf2y.tcool.domain.Note;
import com.kf2y.tcool.repository.NoteRepository;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	NoteRepository noteRepo;

	@Override
	public Note save(Note n) {
		// TODO Auto-generated method stub
		return noteRepo.save(n);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 noteRepo.deleteById(id);;
	}

	@Override
	public Note getById(Long id) {
		// TODO Auto-generated method stub
		Note note = noteRepo.findById(id).orElse(null);
		if(note == null) {
			throw new RuntimeException("note avec id= "+id+" introuvable!");
			}  else return note;
	}

	@Override
	public Note getByContent(String content) {
		// TODO Auto-generated method stub
		return null;
	}

}
