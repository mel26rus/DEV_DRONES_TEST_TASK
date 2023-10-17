package com.example.drones.models;

import com.example.drones.schemes.DroneScheme;
import com.example.drones.schemes.MedicationScheme;

import javax.validation.constraints.NotNull;

public class LoadMedication {
    @NotNull
    DroneScheme droneScheme;
    @NotNull
    MedicationScheme medicationScheme;


    public LoadMedication(DroneScheme droneScheme, MedicationScheme medicationScheme) {
        this.droneScheme = droneScheme;
        this.medicationScheme = medicationScheme;
    }

    public DroneScheme getDroneScheme() {
        return droneScheme;
    }

    public void setDroneScheme(DroneScheme droneScheme) {
        this.droneScheme = droneScheme;
    }

    public MedicationScheme getMedicationScheme() {
        return medicationScheme;
    }

    public void setMedicationScheme(MedicationScheme medicationScheme) {
        this.medicationScheme = medicationScheme;
    }
}
