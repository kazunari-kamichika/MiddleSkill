package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GenderEntity;
import com.example.demo.repository.GenderRepository;

/**
 * 性別 Service
 */
@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    /**
     * 全ての性別を取得
     * @return 性別リスト
     */
    public List<GenderEntity> getAllGenders() {
        return genderRepository.findAll();
    }
}