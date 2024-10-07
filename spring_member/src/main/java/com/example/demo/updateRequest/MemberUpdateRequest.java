package com.example.demo.updateRequest;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.example.demo.form.MemberForm;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザー情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class MemberUpdateRequest extends MemberForm implements Serializable {
	
	/**
	   * ユーザーID
	   */
	  @NotNull
	  private Integer id;

}
