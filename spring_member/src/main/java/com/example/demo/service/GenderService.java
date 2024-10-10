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