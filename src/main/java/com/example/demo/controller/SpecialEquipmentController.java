package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SpecialEquipment;
import com.example.demo.repository.SpecialEquipmentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipment")
public class SpecialEquipmentController {

    @Autowired
    private SpecialEquipmentRepository specialEquipmentRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addEquipment(@RequestBody SpecialEquipment equipment) {
        // Check if the equipment already exists
        Optional<SpecialEquipment> existingEquipment = specialEquipmentRepository.findByEquipmentName(equipment.getEquipmentName());
        if (existingEquipment.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Equipment already exists!");
        }

        // Save the new equipment
        specialEquipmentRepository.save(equipment);
        return ResponseEntity.ok("Equipment added successfully!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<SpecialEquipment>> getAllEquipment() {
        List<SpecialEquipment> equipmentList = specialEquipmentRepository.findAll();
        return ResponseEntity.ok(equipmentList);
    }

    @GetMapping("/{equipmentName}")
    public ResponseEntity<SpecialEquipment> getEquipmentByName(@PathVariable String equipmentName) {
        Optional<SpecialEquipment> equipment = specialEquipmentRepository.findByEquipmentName(equipmentName);
        if (equipment.isPresent()) {
            return ResponseEntity.ok(equipment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{equipmentName}")
    public ResponseEntity<String> deleteEquipment(@PathVariable String equipmentName) {
        Optional<SpecialEquipment> equipment = specialEquipmentRepository.findByEquipmentName(equipmentName);
        if (equipment.isPresent()) {
            specialEquipmentRepository.delete(equipment.get());
            return ResponseEntity.ok("Equipment deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
