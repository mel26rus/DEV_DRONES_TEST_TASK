package com.example.drones.schemes;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class MedicationScheme implements Serializable {

    /*
            Each MedicationScheme has:
            name (allowed only letters, numbers, ‘-‘, ‘_’);
            weight;
            code (allowed only upper case letters, underscore and numbers);
            image (picture of the medication case).
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private Long weight;
    private String code;
    private String image;

    public MedicationScheme() {
    }

    public MedicationScheme(String name, Long weight, String code, String image) {
        this.setName(name);
        this.weight = weight;
        this.setCode(code);
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws RuntimeException {
        if (checkRegEx("^[a-zA-Z0-9_-]*$", name)) {
            this.name = name;
        } else {
            throw new RuntimeException("Unknown name. You can use only letters, numbers, ‘-‘, ‘_’");
        }

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

    public void setCode(String code) throws RuntimeException {
        if (checkRegEx("^[A-Z0-9_]*$", code)) {
            this.code = code;
        } else {
            throw new RuntimeException("Unknown code. Allowed only upper case letters, underscore and numbers");
        }

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private boolean checkRegEx(String regex, String input) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
    }


}
