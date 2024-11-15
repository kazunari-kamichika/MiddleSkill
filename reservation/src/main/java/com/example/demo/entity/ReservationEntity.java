package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;



@Data // Lombokでゲッター・セッターを自動生成
@Entity
@Table(name = "reservations")
public class ReservationEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // PlanEntityとの関連付け
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false) // 外部キーplan_idを指定
    private PlanEntity plan;

    // UserEntityとの関連付け
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // 外部キーuser_idを指定
    private UserEntity user;

    @Column(name = "reservation_date", nullable = false)
    private LocalDateTime reservationDate; // 予約日時

}
