package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PlanEntity;
import com.example.demo.repository.PlanRepository;

@Service
public class PlanService {
	
	@Autowired
    private PlanRepository planRepository;

    // DBからプラン情報を取得し、Mapに格納
    public Map<Integer, PlanEntity> getAllPlans() {
        Map<Integer, PlanEntity> plansMap = new HashMap<>();
        planRepository.findAll().forEach(plan -> {
            plansMap.put(plan.getId(), plan);
        });
        return plansMap;
    }

}
