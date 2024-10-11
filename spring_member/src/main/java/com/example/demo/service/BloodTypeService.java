package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BloodTypeEntity;
import com.example.demo.repository.BloodTypeRepository;

@Service
public class BloodTypeService {

	@Autowired
	BloodTypeRepository bloodTypeRepository;

	public Map<Integer, String> getBloodTypes() {
		List<BloodTypeEntity> bloodTypes = bloodTypeRepository.findAll();
		Map<Integer, String> bloodTypeMap = new HashMap<>();
		for (BloodTypeEntity bloodType : bloodTypes) {
			bloodTypeMap.put(bloodType.getId(), bloodType.getName());
		}
		return bloodTypeMap;
	}
	
	
}