package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class BloodTypeService {
    private final Map<Integer, String> bloodTypes = new HashMap<>();

    public BloodTypeService() {
        bloodTypes.put(1, "A");
        bloodTypes.put(2, "B");
        bloodTypes.put(3, "O");
        bloodTypes.put(4, "AB");
    }

    public Map<Integer, String> getBloodTypes() {
        return bloodTypes;
    }
}