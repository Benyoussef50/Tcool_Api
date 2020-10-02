package com.kf2y.tcool.service;

import java.util.Date;
import java.util.List;

import com.kf2y.tcool.domain.Reservation;

public interface ReservationService {
	
	public Reservation save(Reservation r);
	public void delete(Long id);
	public List<Reservation> getAllReservation();
	public boolean existByDayandHour(Date day, int hour);
}
