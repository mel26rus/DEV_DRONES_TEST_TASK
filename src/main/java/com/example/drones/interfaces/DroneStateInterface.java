package com.example.drones.interfaces;

import com.example.drones.schemes.DroneStateScheme;
import org.springframework.data.repository.CrudRepository;

public interface DroneStateInterface extends CrudRepository<DroneStateScheme, Long> {
          DroneStateScheme findByTitle(String title);
}
