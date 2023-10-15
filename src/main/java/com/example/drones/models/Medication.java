package com.example.drones.models;

import javax.validation.constraints.NotNull;

public class Medication {

    //    Each Medication has:
//
//    name (allowed only letters, numbers, ‘-‘, ‘_’);
//    weight;
//    code (allowed only upper case letters, underscore and numbers);
//    image (picture of the medication case).
    @NotNull
    String name;
    @NotNull
    Long weight;
    @NotNull
    String code;
    @NotNull
    String image;

    public Medication() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
