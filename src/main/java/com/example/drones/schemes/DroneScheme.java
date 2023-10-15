package com.example.drones.schemes;

import jakarta.persistence.*;

import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
public class DroneScheme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(max = 100)
    private String serial_number;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "model_id")
    private DroneModelScheme model;

    @Size(max = 500)
    private int weight_limit;

    @Size(max = 100)
    private int battery;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "state_id")
    private DroneStateScheme state;

    public DroneScheme() {    }

    public DroneScheme(String serial_number, DroneModelScheme model, int weight_limit, int battery, DroneStateScheme state) {
        this.serial_number = serial_number;
        this.model = model;
        this.weight_limit = weight_limit;
        this.battery = battery;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public DroneModelScheme getModel() {
        return model;
    }

    public void setModel(DroneModelScheme model) {
        this.model = model;
    }

    public DroneStateScheme getState() {
        return state;
    }

    public void setState(DroneStateScheme state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DroneScheme{" +
                "id=" + id +
                ", serial_number='" + serial_number + '\'' +
                ", model=" + model +
                ", weight_limit=" + weight_limit +
                ", battery=" + battery +
                ", state=" + state +
                '}';
    }
}
