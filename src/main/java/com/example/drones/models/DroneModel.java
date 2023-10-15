package com.example.drones.models;


import javax.validation.constraints.NotNull;

public class DroneModel {
    @NotNull
    private String title;

    public DroneModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
