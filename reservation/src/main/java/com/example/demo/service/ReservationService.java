package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ReservationDetailsDTO;
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

	public List<ReservationDetailsDTO> getAllReservations() {
		List<ReservationEntity> reservations = reservationRepository.findAllReservationsWithUserAndPlan();
		return reservations.stream().map(entity -> {
			ReservationDetailsDTO dto = new ReservationDetailsDTO();
			// ユーザー情報
			dto.setUserName(entity.getUser().getName());
			dto.setUserPhone(entity.getUser().getPhone());
			dto.setUserEmail(entity.getUser().getEmail());
			// プラン情報
			dto.setPlanName(entity.getPlan().getName());
			dto.setPlanPrice(entity.getPlan().getPrice());
			// 予約日時
			dto.setReservationDate(entity.getReservationDate());
			return dto;
		}).collect(Collectors.toList());
		/*collect メソッドの役割
		collect は、ストリーム操作の最終的な結果を「収集」するためのターミナル操作（Terminal Operation）です。
		Collectors.toList() を使用すると、ストリームの結果をリスト（List）としてまとめます。*/
	}

}
