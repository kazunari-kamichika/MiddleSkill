package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BloodTypeEntity;

/**
 * 血液型 Repository
 */
@Repository
public interface BloodTypeRepository extends JpaRepository<BloodTypeEntity, Integer> {
}
