package com.kf2y.tcool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kf2y.tcool.domain.Note;


public interface NoteRepository extends JpaRepository<Note, Long>{

}
