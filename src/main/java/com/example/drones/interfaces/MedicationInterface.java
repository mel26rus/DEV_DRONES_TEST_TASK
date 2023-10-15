package com.example.drones.interfaces;

import com.example.drones.schemes.MedicationScheme;
import org.springframework.data.repository.CrudRepository;

public interface MedicationInterface extends CrudRepository<MedicationScheme, Long> {
}
