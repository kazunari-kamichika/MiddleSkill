package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class GenderService {

    // 性別情報を取得するメソッド
    public Map<Integer, String> getGenders() {
        Map<Integer, String> genderMap = new HashMap<>();
        genderMap.put(1, "男性");
        genderMap.put(2, "女性");
        genderMap.put(3, "その他");
        return genderMap;
    }
}