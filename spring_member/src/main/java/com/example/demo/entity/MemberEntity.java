package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
* メンバー情報 Entity
*/
@Data
@Entity
@Table(name = "member")
public class MemberEntity {

	/**
	 * ID
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
	 * 名前
	 */
    @Column(name = "name")
    private String name;

    /**
	 * 年齢
	 */
    @Column(name = "age")
    private Integer age;

    /**
	 * 性別
	 */
	@Column(name = "gender_id")
	private Integer genderId; 

	/**
	 * 血液型
	 */
    @Column(name = "blood_type_id")
    private Integer blood_type_id;
    
    /**
	 * 生年月日
	 */
    @Column(name = "birthday")
    private LocalDate birthday;
    
    
    

}