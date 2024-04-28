package com.example.demo.repository;

import com.example.demo.model.SpecialEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialEquipmentRepository extends JpaRepository<SpecialEquipment, Long> {

    Optional<SpecialEquipment> findByEquipmentName(String equipmentName);
    
}
