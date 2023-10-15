package com.example.drones.schemes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Validated
@Entity
public class DroneModelScheme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    //model (Lightweight, Middleweight, Cruiserweight, Heavyweight);


    public DroneModelScheme() {
    }

    public DroneModelScheme(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
