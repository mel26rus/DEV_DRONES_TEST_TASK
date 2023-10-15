package com.example.drones.controllers;


import com.example.drones.interfaces.MedicationInterface;
import com.example.drones.models.Medication;
import com.example.drones.schemes.MedicationScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medic")
public class MedicationController {

    @Autowired
    MedicationInterface medicationInterface;

    @GetMapping()
    public List<MedicationScheme> returnStates() {
        return (List<MedicationScheme>) medicationInterface.findAll();
    }

    @PostMapping("/add")
    public MedicationScheme insertMedication(@RequestBody Medication medication) {
        MedicationScheme medicationScheme = new MedicationScheme();
        medicationScheme.setCode(medication.getCode());
        medicationScheme.setName(medication.getName());
        medicationScheme.setWeight(medication.getWeight());
        medicationScheme.setImage(medication.getImage());
        medicationInterface.save(medicationScheme);
        return medicationInterface.findById(medicationScheme.getId()).get();
    }
}
