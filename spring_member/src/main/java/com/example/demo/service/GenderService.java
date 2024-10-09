package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GenderEntity;
import com.example.demo.repository.GenderRepository;

@Service
public class GenderService {

    // 性別情報を取得するメソッド
//    public Map<Integer, String> getGenders() {
//        Map<Integer, String> genderMap = new HashMap<>();
//        genderMap.put(1, "男性");
//        genderMap.put(2, "女性");
//        genderMap.put(3, "その他");
//        return genderMap;
//    }
	
	
	 @Autowired
	    private GenderRepository GenderRepository;
	
	 public Map<Integer, String> getGenders() {
	        List<GenderEntity> genders = GenderRepository.findAll();
	        Map<Integer, String> genderMap = new HashMap<>();
	        for (GenderEntity gender : genders) {
	            genderMap.put(gender.getId(), gender.getName());
	        }
	        return genderMap;
	    }
}