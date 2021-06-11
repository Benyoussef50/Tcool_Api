package com.kf2y.tcool.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf2y.tcool.domain.Artisan;
import com.kf2y.tcool.domain.Evenement;
import com.kf2y.tcool.domain.Note;
import com.kf2y.tcool.exception.ResourceNotFoundException;
import com.kf2y.tcool.service.ArtisanServiceImpl;
import com.kf2y.tcool.service.NoteServiceImpl;

@RestController
@RequestMapping("/api/artisans")
public class ArtisanController {
	
	@Autowired
	private ArtisanServiceImpl artisanService;
	
	@Autowired
	private NoteServiceImpl noteService;
	
	/************************ Get an artisan **************************/
	@GetMapping("/{id}")
	public Artisan getArtisan(@PathVariable Long id) {
		return artisanService.getById(id);
	}
	
	/********************** Save an artisan **********************/
	@PostMapping("/save-artisan")
	public Artisan saveArtisan(@RequestBody Artisan artisan) {
		return artisanService.save(artisan);
	}
	
	/*********************** Delete discussion ********************/
	@DeleteMapping("/delete/{id}")
	@Transactional
	public void deleteArtisan(@PathVariable Long id) {
		artisanService.delete(id);
	}
	
	/************************* Get all discussions ********************/
	@GetMapping("/all")
	public List<Artisan> getAll(){
		return artisanService.getAllArtisans();
	}
	
	// update an account
		@PutMapping("/update/{id}")
		@Transactional
		public Artisan updateArtisan(@PathVariable Long id ,@RequestBody Note note) 
			throws ResourceNotFoundException {
			Artisan a = artisanService.getById(id);
			System.out.println("wesh id : "+id);
			Note n = noteService.save(note);
			if(a == null) throw new ResourceNotFoundException("Artisan not found on :: "+ a.getIdArtisan());
			List<Note> myNotes = a.getMyNotes();
			myNotes.add(n);
			a.setMyNotes(myNotes);
			double myNote = 0;
			for(Note not : myNotes) {
				   myNote = myNote + not.getValeur();
				}
			myNote = Math.round(((myNote)/(myNotes.size()))*10.0)/10.0;
			a.setNote(myNote);
			System.out.println("my Artisan ");
			System.out.print(myNote);
			
			artisanService.save(a);
			return artisanService.getById(id);
		}

}
