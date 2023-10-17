package com.example.drones.models;

import com.example.drones.schemes.DroneModelScheme;
import com.example.drones.schemes.DroneStateScheme;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Drone {
    @NotNull
    @Size(max = 100)
    private String serial_number;
    @NotNull
    private DroneModelScheme droneModelScheme;
    @NotNull
    @Size(max = 500)
    private int weight_limit;
    @NotNull
    @Size(max = 100)
    private int battery;
    @NotNull
    private DroneStateScheme droneStateScheme;


    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }


    public int getWeight_limit() {
        return weight_limit;
    }

    public void setWeight_limit(int weight_limit) {
        this.weight_limit = weight_limit;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public DroneModelScheme getDroneModelScheme() {
        return droneModelScheme;
    }

    public void setDroneModelScheme(DroneModelScheme droneModelScheme) {
        this.droneModelScheme = droneModelScheme;
    }

    public DroneStateScheme getDroneStateScheme() {
        return droneStateScheme;
    }

    public void setDroneStateScheme(DroneStateScheme droneStateScheme) {
        this.droneStateScheme = droneStateScheme;
    }

    public Drone(String serial_number, DroneModelScheme droneModelScheme, int weight_limit, int battery, DroneStateScheme droneStateScheme) {
        this.serial_number = serial_number;
        this.droneModelScheme = droneModelScheme;
        this.weight_limit = weight_limit;
        this.battery = battery;
        this.droneStateScheme = droneStateScheme;
    }
}
