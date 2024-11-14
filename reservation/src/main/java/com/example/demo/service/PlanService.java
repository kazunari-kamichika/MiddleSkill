package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PlanEntity;
import com.example.demo.repository.PlanRepository;

@Service
public class PlanService {
	
	@Autowired
    private PlanRepository planRepository;

	 // 全プランを取得
    public List<PlanEntity> getAllPlans() {
        return planRepository.findAll();  // データベースから全プランを取得
    }

    // IDでプランを取得
    public PlanEntity getPlanById(Long planId) {
        return planRepository.findById(planId).orElse(null);  // IDでプランを取得
    }

}
