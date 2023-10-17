package com.example.drones.controllers;

import com.example.drones.interfaces.DroneInterface;
import com.example.drones.interfaces.DroneModelInterface;
import com.example.drones.interfaces.DroneStateInterface;
import com.example.drones.models.Drone;
import com.example.drones.schemes.DroneScheme;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class DroneControllerTest {

    @Autowired
    DroneInterface droneInterface;
    @Autowired
    DroneModelInterface droneModelInterface;
    @Autowired
    DroneStateInterface droneStateInterface;
    @Test
    void showDrones() {
        List<DroneScheme> droneModels = new DroneController(droneStateInterface, droneModelInterface, droneInterface).showDrones();
        assertThat(droneModels).hasSize(((List<DroneScheme>) droneInterface.findAll()).size());
        assertThat(droneModels.get(0).getSerial_number()).isEqualTo("James007");
    }

    @Test
    void returnDrone() {
        DroneScheme droneScheme = new DroneController(droneStateInterface, droneModelInterface, droneInterface).returnDrone(Long.valueOf(1)).get();
        assertThat(droneScheme.getSerial_number()).isEqualTo("James007");
    }

    @Test
    void returnAvailableDrones() {
        List<DroneScheme> droneScheme = new DroneController(droneStateInterface, droneModelInterface, droneInterface).returnAvailableDrones();
        assertThat(droneScheme.get(0).getSerial_number()).isEqualTo("James007");
    }
    @Test
    void insertDrone() {
        Drone drone = new Drone("test", droneModelInterface.findById(1L).get() ,100,100,droneStateInterface.findById(1L).get());
        Long size = droneInterface.count();
        new DroneController(droneStateInterface, droneModelInterface, droneInterface).insertDrone(drone);
        assertThat(droneInterface.findAll()).hasSize((int) (size+1));
    }
}