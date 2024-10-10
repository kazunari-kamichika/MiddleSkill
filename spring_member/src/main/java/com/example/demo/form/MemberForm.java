package com.example.demo.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
* メンバー情報 リクエストデータ
*/
@Data
public class MemberForm {

	/**
	  * ID
	  */
	private Integer id;

	/**
	* 名前
	*/
	@NotEmpty(message = "名前を入力してください")
	@Size(max = 100, message = "名前は100文字以内で入力してください")
	private String name;

	/**
	* 年齢
	*/
	@NotNull(message = "年齢を入力してください")
	private Integer age;

	// 生年月日のフィールドを追加
	@NotNull(message = "生年月日を入力してください")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;

	/**
	* 性別
	*/
	@NotNull
	private Integer gender_id;

	/**
	* 血液型
	*/
	private Integer blood_type_id;

}
