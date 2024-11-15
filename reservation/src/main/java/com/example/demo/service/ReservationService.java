package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ReservationEntity;
import com.example.demo.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
    private ReservationRepository reservationRepository;

    public ReservationEntity saveReservation(ReservationEntity reservation) {
        return reservationRepository.save(reservation);
    }

    public ReservationEntity getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

}
