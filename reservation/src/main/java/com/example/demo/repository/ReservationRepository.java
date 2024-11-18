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



/*
SELECT 
r.id AS reservation_id,
r.reservation_date,
u.id AS user_id,
u.name AS user_name,
u.phone AS user_phone,
u.email AS user_email,
p.id AS plan_id,
p.name AS plan_name,
p.price AS plan_price
FROM 
reservations r
JOIN 
users u ON r.user_id = u.id
JOIN 
plans p ON r.plan_id = p.id;
*/