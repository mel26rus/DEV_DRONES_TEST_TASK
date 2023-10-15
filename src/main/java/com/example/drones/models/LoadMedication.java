package com.example.drones.models;

import javax.validation.constraints.NotNull;

public class LoadMedication {
    @NotNull
    Long drone_id;
    @NotNull
    Long medication_id;


    public LoadMedication(Long drone_id, Long medication_id) {
        this.drone_id = drone_id;
        this.medication_id = medication_id;
    }

    public Long getDrone_id() {
        return drone_id;
    }

    public void setDrone_id(Long drone_id) {
        this.drone_id = drone_id;
    }

    public Long getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(Long medication_id) {
        this.medication_id = medication_id;
    }

}
