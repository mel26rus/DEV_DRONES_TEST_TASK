package com.example.drones.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Drone {
    @NotNull
    @Size(max = 100)
    private String serial_number;
    @NotNull
    private Long model_id;
    @NotNull
    @Size(max = 500)
    private int weight_limit;
    @NotNull
    @Size(max = 100)
    private int battery;
    @NotNull
    private Long state_id;

    @Override
    public String toString() {
        return "DroneScheme{" +
                "serial_number='" + serial_number + '\'' +
                ", model_id=" + model_id +
                ", weight_limit=" + weight_limit +
                ", battery=" + battery +
                ", state_id=" + state_id +
                '}';
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public Long getModel_id() {
        return model_id;
    }

    public void setModel_id(Long model_id) {
        this.model_id = model_id;
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

    public Long getState_id() {
        return state_id;
    }

    public void setState_id(Long state_id) {
        this.state_id = state_id;
    }

    public Drone(String serial_number, Long model_id, int weight_limit, int battery, Long state_id) {
        this.serial_number = serial_number;
        this.model_id = model_id;
        this.weight_limit = weight_limit;
        this.battery = battery;
        this.state_id = state_id;
    }
}
