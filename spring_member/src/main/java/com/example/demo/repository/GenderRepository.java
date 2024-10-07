package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GenderEntity;

/**
 * 性別 Repository
 */
@Repository
public interface GenderRepository extends JpaRepository<GenderEntity, Integer> {
}