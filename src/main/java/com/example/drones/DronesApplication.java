package com.example.drones;


import com.example.drones.interfaces.DroneInterface;
import com.example.drones.interfaces.DroneModelInterface;
import com.example.drones.interfaces.DroneStateInterface;
import com.example.drones.interfaces.MedicationInterface;
import com.example.drones.schemes.DroneScheme;
import com.example.drones.schemes.MedicationScheme;
import com.example.drones.schemes.DroneModelScheme;
import com.example.drones.schemes.DroneStateScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DronesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DronesApplication.class, args);
    }

    @Autowired
    DroneModelInterface droneModelInterface;
    @Autowired
    DroneStateInterface droneStateInterface;
    @Autowired
    MedicationInterface medicationInterface;
    @Autowired
    DroneInterface droneInterface;


    @Override
    public void run(String... args) throws Exception {
        try {
            if (droneModelInterface.count() == 0) {
                droneModelInterface.deleteAll();
                //model (Lightweight, Middleweight, Cruiserweight, Heavyweight);
                DroneModelScheme lightweight = new DroneModelScheme("Lightweight");
                DroneModelScheme middleweight = new DroneModelScheme("Middleweight");
                DroneModelScheme cruiserweight = new DroneModelScheme("Cruiserweight");
                DroneModelScheme heavyweight = new DroneModelScheme("Heavyweight");
                List<DroneModelScheme> models = Arrays.asList(lightweight, middleweight, cruiserweight, heavyweight);
                droneModelInterface.saveAll(models);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }

        try {
            if (droneStateInterface.count() == 0) {
                droneStateInterface.deleteAll();
                //    state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING)
                DroneStateScheme IDLE = new DroneStateScheme("IDLE");
                DroneStateScheme LOADING = new DroneStateScheme("LOADING");
                DroneStateScheme LOADED = new DroneStateScheme("LOADED");
                DroneStateScheme DELIVERING = new DroneStateScheme("DELIVERING");
                DroneStateScheme DELIVERED = new DroneStateScheme("DELIVERED");
                DroneStateScheme RETURNING = new DroneStateScheme("RETURNING");
                List<DroneStateScheme> droneStateSchemeList = Arrays.asList(IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING);
                droneStateInterface.saveAll(droneStateSchemeList);
            }
        } catch (Exception e) {
            throw new Exception("run: cant add default drone states " + e);
        }

        try {
            if (medicationInterface.count() == 0) {
                MedicationScheme analgin = new MedicationScheme("Analgin", 300L, "AN55", "an.png");
                MedicationScheme numb = new MedicationScheme("NUMB", 100L, "NU66", "numb.png");
                MedicationScheme tap = new MedicationScheme("Tap", 1000L, "TA307", "tap.png");
                List<MedicationScheme> medicationSchemes = Arrays.asList(analgin, numb, tap);
                medicationInterface.saveAll(medicationSchemes);
            }
        } catch (Exception e) {
            Log("run: cant add default medications " + e);
        }

        try {
            if (droneInterface.count() == 0) {
                DroneScheme james = new DroneScheme("James007", droneModelInterface.findById(1L).get(), 300, 100, droneStateInterface.findById(1L).get());
                DroneScheme beavis = new DroneScheme("Beavis007", droneModelInterface.findById(2L).get(), 400, 10, droneStateInterface.findById(1L).get());
                DroneScheme mc = new DroneScheme("MC007", droneModelInterface.findById(3L).get(), 500, 20, droneStateInterface.findById(3L).get());
                DroneScheme mavic001 = new DroneScheme("Mavic001", droneModelInterface.findById(4L).get(), 100, 30, droneStateInterface.findById(1L).get());
                DroneScheme mavic002 = new DroneScheme("Mavic002", droneModelInterface.findById(1L).get(), 200, 100, droneStateInterface.findById(1L).get());
                DroneScheme mavic003 = new DroneScheme("Mavic003", droneModelInterface.findById(2L).get(), 300, 100, droneStateInterface.findById(1L).get());
                DroneScheme mavic004 = new DroneScheme("Mavic004", droneModelInterface.findById(3L).get(), 400, 10, droneStateInterface.findById(3L).get());
                DroneScheme mavic005 = new DroneScheme("Mavic005", droneModelInterface.findById(4L).get(), 300, 20, droneStateInterface.findById(1L).get());
                DroneScheme mavic006 = new DroneScheme("Mavic006", droneModelInterface.findById(3L).get(), 100, 30, droneStateInterface.findById(1L).get());
                DroneScheme mavic007 = new DroneScheme("Mavic007", droneModelInterface.findById(4L).get(), 500, 100, droneStateInterface.findById(1L).get());

                droneInterface.saveAll(Arrays.asList(james, beavis, mc, mavic001, mavic002, mavic003, mavic004, mavic005, mavic006, mavic007));
            }
        } catch (Exception e) {
            Log("run: cant add default drones: " + e);
        }
    }

    public void Log(String text) {
        System.out.println(text);
    }
}
