package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 性別 Entity
 */
@Data
@Entity
@Table(name = "gender")
public class GenderEntity {

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