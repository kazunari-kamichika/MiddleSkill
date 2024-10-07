package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MemberEntity;
import com.example.demo.form.MemberForm;
import com.example.demo.repository.MemberRepository;
import com.example.demo.updateRequest.MemberUpdateRequest;

/**
* メンバー情報 Service
*/
@Service
public class MemberService {
	
	 /**
	   * メンバー情報 Repository
	   */
	  @Autowired
	  private MemberRepository memberRepository;
	  
	  /**
	   * メンバー情報 全検索
	   * @return  検索結果
	   */
	  public List<MemberEntity> searchAll() {
	      return memberRepository.findAll();
	  }
	  
	  
	  /**
	   * メンバー情報 新規登録
	   * @param  member メンバー情報
	   */
	  public void create(MemberForm memberRequest) {
	    MemberEntity member = new MemberEntity();
	    member.setId(memberRequest.getId());
	    member.setName(memberRequest.getName());
	    member.setAge(memberRequest.getAge());
	    member.setGenderId(memberRequest.getGender_id());
	    member.setBlood_type_id(memberRequest.getBlood_type_id());
	    memberRepository.save(member);
	  }
	  
	  /**
	    * メンバー情報 主キー検索
	    * @return  検索結果
	    */
	   public MemberEntity findById(Integer id) {
	       return memberRepository.getOne(id);
	   }
	  
	   /**
	    * メンバー情報 更新
	    * @param member メンバー情報
	    */
	   public void update(MemberForm memberUpdateRequest) {
	       MemberEntity member = findById(memberUpdateRequest.getId());
	       member.setName(memberUpdateRequest.getName());
	       member.setAge(memberUpdateRequest.getAge());
	       member.setGenderId(memberUpdateRequest.getGender_id());
	       member.setBlood_type_id(memberUpdateRequest.getBlood_type_id());
	       memberRepository.save(member);
	   }
	   
	   /**
	    * メンバー情報 更新
	    * @param user メンバー情報
	    */
	   public void update(MemberUpdateRequest memberUpdateRequest) {
	     MemberEntity member = findById(memberUpdateRequest.getId());
	     member.setName(memberUpdateRequest.getName());
	     member.setAge(memberUpdateRequest.getAge());
	     member.setGenderId(memberUpdateRequest.getGender_id());
	     member.setBlood_type_id(memberUpdateRequest.getBlood_type_id());
	     memberRepository.save(member);
	   }
	   
	   /**
	     * メンバー情報 物理削除
	     * @param id メンバーID
	     */
	    public void delete(Integer id) {
	    	MemberEntity member = findById(id);
	    	memberRepository.delete(member);
	    }

}