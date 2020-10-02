package com.kf2y.tcool.web;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf2y.tcool.domain.Reservation;
import com.kf2y.tcool.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationService service;
	
	@PostMapping("/save-reservation")
	public Reservation saveRReservation(@RequestBody Reservation item) {
		return service.save(item);
	}
	
	@GetMapping("/all")
	public List<Reservation> getAll() {
		return service.getAllReservation();
	}
	
	@DeleteMapping("/delete/{id}")
	@Transactional
	public void deleteReservation(@PathVariable Long id) {
		service.delete(id);
	}

}
