package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 血液型 Entity
 */
@Data
@Entity
@Table(name = "blood_type")
public class BloodTypeEntity {

	/**
	 * ID
	 */
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * 性別名
	 */
	@Column(name = "name")
	private String name;

}
