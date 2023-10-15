package com.example.drones.schemes;

import jakarta.persistence.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Validated
@Entity
public class DroneStateScheme implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String title;
    //    state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING)

    public DroneStateScheme(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DroneStateScheme() {
    }

    @Override
    public String toString() {
        return title;
    }
}
