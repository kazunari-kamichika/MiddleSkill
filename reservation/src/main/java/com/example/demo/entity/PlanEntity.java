package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data // Lombokの@Dataを使うことで、ゲッター・セッター・toStringなどを省略できます
@Table(name = "Plans")
public class PlanEntity {

    @Id
    private Integer id;
    
    private String name;
    
    private Double price;
    
    private String description;
	

}
