package com.kf2y.tcool.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kf2y.tcool.domain.Reservation;
import com.kf2y.tcool.repository.ReservationRepository;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository repo;
	
	@Override
	public Reservation save(Reservation r) {
		return repo.save(r);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Reservation> getAllReservation() {
		return repo.findAll();
	}

	@Override
	public boolean existByDayandHour(Date day, int hour) {
		// TODO Auto-generated method stub
		return false;
	}

}
