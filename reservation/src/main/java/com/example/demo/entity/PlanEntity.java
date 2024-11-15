package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data // Lombokの@Dataを使うことで、ゲッター・セッター・toStringなどを省略できます
@Table(name = "Plans")
public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private BigDecimal price;
    
    private String description;
	
    @OneToMany(mappedBy = "plan")
    private List<ReservationEntity> reservations;  // プランに関連する予約リスト

}
