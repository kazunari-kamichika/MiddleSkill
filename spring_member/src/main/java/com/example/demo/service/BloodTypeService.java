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
	
//    private final Map<Integer, String> bloodTypes = new HashMap<>();

//    public BloodTypeService() {
//        bloodTypes.put(1, "A");
//        bloodTypes.put(2, "B");
//        bloodTypes.put(3, "O");
//        bloodTypes.put(4, "AB");
//    }
//
//    public Map<Integer, String> getBloodTypes() {
//        return bloodTypes;
//    }
    
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