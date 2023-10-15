package com.example.drones.schemes;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class LoadMedicationScheme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "drone_id")
    private DroneScheme droneScheme;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "medication_id")
    private MedicationScheme medicationScheme;

    public LoadMedicationScheme() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
