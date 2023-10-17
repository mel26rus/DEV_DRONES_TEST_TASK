package com.example.drones.models;



import com.example.drones.schemes.DroneScheme;
import com.example.drones.schemes.MedicationScheme;

import java.util.List;

public class DroneWithMed {
    private DroneScheme droneScheme;
    private List<MedicationScheme> medicationSchemes;

    public DroneWithMed(DroneScheme droneScheme, List<MedicationScheme> medicationSchemes) {
        this.droneScheme = droneScheme;
        this.medicationSchemes = medicationSchemes;
    }

    public DroneScheme getDroneScheme() {
        return droneScheme;
    }

    public void setDroneScheme(DroneScheme droneScheme) {
        this.droneScheme = droneScheme;
    }

    public List<MedicationScheme> getMedicationSchemes() {
        return medicationSchemes;
    }

    public void setMedicationSchemes(List<MedicationScheme> medicationSchemes) {
        this.medicationSchemes = medicationSchemes;
    }
}
