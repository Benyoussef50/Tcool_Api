package com.kf2y.tcool.service;

import com.kf2y.tcool.domain.Note;

public interface NoteService {

	public Note save(Note n);
	public void delete(Long id);
	public Note getById(Long id);
	public Note getByContent(String content);
}
