package com.example.drones.interfaces;

import com.example.drones.schemes.DroneModelScheme;
import org.springframework.data.repository.CrudRepository;

public interface DroneModelInterface extends CrudRepository<DroneModelScheme, Long> {
//    Long countDistinctById();
}
