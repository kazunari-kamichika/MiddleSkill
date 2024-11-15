package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ReservationEntity;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    // 必要に応じてカスタムクエリメソッドを追加
	
	// 予約情報をユーザー情報とプラン情報を結合して取得
	// Reservations with User and Plan details
	 @Query("SELECT r FROM ReservationEntity r JOIN FETCH r.user u JOIN FETCH r.plan p")
	    List<ReservationEntity> findAllReservationsWithUserAndPlan();
}
