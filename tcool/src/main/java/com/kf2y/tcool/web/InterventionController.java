package com.kf2y.tcool.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kf2y.tcool.domain.Intervention;
import com.kf2y.tcool.domain.Message;
import com.kf2y.tcool.service.InterventionServiceImpl;
import com.kf2y.tcool.service.file.FilesStorageService;

@RestController
@RequestMapping("api/interventions")
public class InterventionController {

	@Autowired
	private InterventionServiceImpl impl;
	
	@Autowired
	FilesStorageService storageService;

	@PostMapping("/save-intervention")
	public Intervention saveInter(@RequestBody Intervention intervention) {
		return impl.save(intervention);
	}

	@DeleteMapping("/delete/{id}")
	@Transactional
	public void deleteInter(@PathVariable Long id) {
		impl.remove(id);
	}

	@GetMapping("/all")
	public List<Intervention> getAll() {
		return impl.findAllIntervention();
	}

	@GetMapping("/encours")
	public List<Intervention> getAllEnCours() {
		return impl.findInterEnCours();
	} 

	@GetMapping("/cloturees")
	public List<Intervention> getAllCloturees() {
		return impl.findInterCloturees();
	}

	@GetMapping("/annulees")
	public List<Intervention> getAllAnnulees() {
		return impl.findInterAnnulees();
	}

	@GetMapping("/{id}")
	public Intervention getById(@PathVariable Long id) {
		return impl.findInterventionById(id);
	}

	@PutMapping("/annuler-status/{id}")
	@Transactional
	public Intervention annulerStatus(@PathVariable Long id) {
		return impl.update("ANNULEE", id);
	}
	
	@PutMapping("/valider-status/{id}")
	@Transactional
	public Intervention validerStatus(@PathVariable Long id) {
		return impl.update("AFFECTER", id);
	}
	
	
	@PutMapping("/affecter-status/{id}")
	@Transactional
	public Intervention affecterStatus(@PathVariable Long id, @RequestBody Intervention inter) {
		inter.setStatus("EN COURS");
		return impl.save(inter);
	}

	@PutMapping("/evaluer-status/{id}/{compteRendu}")
	@Transactional
	public Intervention evaluerStatus(@PathVariable Long id, @PathVariable String compteRendu, @RequestBody Intervention inter) {
		return impl.createCRIntervention("EVALUER", compteRendu, id);
	}

	@PutMapping("/cloturer-status/{id}/{evaluation}")
	@Transactional
	public Intervention cloturerStatus(@PathVariable Long id, @PathVariable String evaluation, @RequestBody Intervention inter) {
		return impl.evaluateIntervention("CLOTUREE", evaluation, id);
	}

	@PutMapping("/add-message/{id}")
	@Transactional
	public Intervention addMessage(@PathVariable Long id, @RequestBody Message msg) {
		return impl.addMessages(id, msg);
	} 
	
	/***************************** upload file ******************************/
	// upload audio
	@PostMapping("/upload-audio")
	public ResponseEntity<String> uploadAudio(@RequestParam("file") MultipartFile file){
		String message = "";
		try {
			storageService.saveAudio(file);
			message = "Upload the audio successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Could not upload the audio: " + file.getOriginalFilename() + "!\n" + e;
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
	// load the audio file
	@GetMapping("/audio/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getAudio(@PathVariable String filename,
			HttpServletRequest req) throws IOException {
		Resource file = storageService.loadAudio(filename);
		
		// try to determine file's content type
		String contentType = null;
		try {
			contentType = req.getServletContext().getMimeType(file.getFile().getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// fallback to the default content type if type could not be determined
		if(contentType == null) {
			contentType = "application/octect-stream";
		}
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
}
