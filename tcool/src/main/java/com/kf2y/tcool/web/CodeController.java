package com.kf2y.tcool.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf2y.tcool.domain.Code;
import com.kf2y.tcool.service.CodeServiceImpl;


@RestController
@RequestMapping("/api/codes")
public class CodeController {
	
	@Autowired
	private CodeServiceImpl codeService;

	
	// get an account by its id
		@GetMapping("/{id}")
		public Code getCode(@PathVariable Long id) {
			return codeService.getById(id);
		}
		
		// save an account
		@PostMapping("/save-code")
		public Code saveCode(@RequestBody Code code) {
			return codeService.save(code);
		}
}
