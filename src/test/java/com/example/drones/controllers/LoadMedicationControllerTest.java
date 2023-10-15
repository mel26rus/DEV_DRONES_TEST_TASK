package com.example.drones.controllers;

import com.example.drones.BaseResponse;
import com.example.drones.interfaces.*;
import com.example.drones.models.LoadMedication;
import com.example.drones.schemes.DroneScheme;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.drones.BaseResponse.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class LoadMedicationControllerTest {

    @Autowired
    DroneInterface droneInterface;
    @Autowired
    DroneModelInterface droneModelInterface;
    @Autowired
    DroneStateInterface droneStateInterface;
    @Autowired
    LoadMedicationInterface loadMedicationInterface;
    @Autowired
    private MedicationInterface medicationInterface;

    @Test
    void loadMedications() {
        LoadMedicationController loadMedicationController = new LoadMedicationController(loadMedicationInterface, droneInterface, medicationInterface, droneStateInterface);
        loadMedicationInterface.deleteAll();
        DroneScheme droneScheme = droneInterface.findById(1L).get();
        droneScheme.setState(droneStateInterface.findById(1L).get());
        droneInterface.save(droneScheme);

        BaseResponse baseResponse = loadMedicationController.loadMedications(new LoadMedication(1L, 2L));
        assertThat(baseResponse.getCode()).isEqualTo(CODE_SUCCESS);
        baseResponse = loadMedicationController.loadMedications(new LoadMedication(1L, 3L));
        assertThat(baseResponse.getCode()).isEqualTo(CODE_ERROR_DATA);

        droneScheme = droneInterface.findById(2L).get();
        droneScheme.setBattery(20);
        droneScheme.setState(droneStateInterface.findById(1L).get());
        droneInterface.save(droneScheme);

        baseResponse = loadMedicationController.loadMedications(new LoadMedication(2L, 3L));
        assertThat(baseResponse.getStatus()).isEqualTo(ERROR_DRONE_NOT_CHARGED);

        droneScheme.setBattery(100);
        droneInterface.save(droneScheme);

    }

}