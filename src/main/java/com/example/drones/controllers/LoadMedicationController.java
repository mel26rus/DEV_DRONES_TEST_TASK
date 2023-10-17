package com.example.drones.controllers;


import com.example.drones.BaseResponse;
import com.example.drones.interfaces.DroneInterface;
import com.example.drones.interfaces.DroneStateInterface;
import com.example.drones.interfaces.LoadMedicationInterface;
import com.example.drones.interfaces.MedicationInterface;
import com.example.drones.models.DroneWithMed;
import com.example.drones.models.LoadMedication;
import com.example.drones.schemes.DroneScheme;
import com.example.drones.schemes.LoadMedicationScheme;
import com.example.drones.schemes.MedicationScheme;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/load")
public class LoadMedicationController {


    LoadMedicationInterface loadMedicationInterface;

    DroneInterface droneInterface;

    MedicationInterface medicationInterface;

    DroneStateInterface droneStateInterface;

    public LoadMedicationController(LoadMedicationInterface loadMedicationInterface, DroneInterface droneInterface, MedicationInterface medicationInterface, DroneStateInterface droneStateInterface) {
        this.loadMedicationInterface = loadMedicationInterface;
        this.droneInterface = droneInterface;
        this.medicationInterface = medicationInterface;
        this.droneStateInterface = droneStateInterface;
    }

    @PostMapping("")
    public BaseResponse loadMedications(@RequestBody LoadMedication loadMeds) {

        DroneScheme droneScheme = loadMeds.getDroneScheme();
        MedicationScheme medicationScheme = loadMeds.getMedicationScheme();

        if ((droneScheme.getState().getId() != 1L) && (droneScheme.getState().getId() != 2L)){
            return new BaseResponse(BaseResponse.ERROR_DRONE_NOT_READY, BaseResponse.CODE_ERROR_DATA);
        }
        if (((loadMedicationInterface.getDroneLoaded(droneScheme.getId()) + medicationScheme.getWeight()) > droneScheme.getWeight_limit())) {
            return new BaseResponse(BaseResponse.ERROR_DRONE_FULL, BaseResponse.CODE_ERROR_DATA);
        }
        if (droneScheme.getBattery() <= 25L) {
            return new BaseResponse(BaseResponse.ERROR_DRONE_NOT_CHARGED, BaseResponse.CODE_ERROR_DATA);
        }
        if(Objects.equals(medicationScheme, medicationInterface.findById(medicationScheme.getId()).get())) {
            return new BaseResponse(BaseResponse.ERROR_WRONG_MED_DATA, BaseResponse.CODE_ERROR_DATA);
        }
        LoadMedicationScheme loadMedicationScheme = new LoadMedicationScheme();
        loadMedicationScheme.setDroneScheme(droneScheme);
        loadMedicationScheme.setMedicationScheme(medicationScheme);
        loadMedicationInterface.save(loadMedicationScheme);

        if (droneScheme.getWeight_limit() == loadMedicationInterface.getDroneLoaded(droneScheme.getId())) {
            droneScheme.setState(droneStateInterface.findByTitle("LOADED"));
        } else {
            droneScheme.setState(droneStateInterface.findByTitle("LOADING"));
        }
        droneInterface.save(droneScheme);
        return new BaseResponse(BaseResponse.SUCCESS_STATUS, BaseResponse.CODE_SUCCESS);
    }
    @GetMapping("/{id}")
    public DroneWithMed returnLoadedMedicationsByDroneID(@PathVariable Long id) {
        DroneScheme droneScheme = droneInterface.findById(id).get();
        List<MedicationScheme> droneWithMedList = new ArrayList<>();
        List<LoadMedicationScheme> loadMedicationScheme = loadMedicationInterface.findByDroneScheme(droneScheme);
        for (LoadMedicationScheme droneWithMed:  loadMedicationScheme) {
            droneWithMedList.add(medicationInterface.findById(droneWithMed.getMedicationScheme().getId()).get());
        }
        return new DroneWithMed(droneScheme, droneWithMedList);
    }

}
