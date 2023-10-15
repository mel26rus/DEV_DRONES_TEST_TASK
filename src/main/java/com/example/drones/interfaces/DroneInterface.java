package com.example.drones.interfaces;

import com.example.drones.schemes.DroneScheme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DroneInterface extends CrudRepository<DroneScheme, Long> {
    @Query(value = """
            select ds.*
            from drone_scheme ds
                     inner join drone_state_scheme dss on ds.state_id = dss.id
            where dss.id in (1, 2)
            and ds.battery > 25
            """, nativeQuery = true)
    List<DroneScheme> returnAvailableDrones();

}
