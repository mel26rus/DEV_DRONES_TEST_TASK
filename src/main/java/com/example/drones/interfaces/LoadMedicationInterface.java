package com.example.drones.interfaces;

import com.example.drones.schemes.DroneScheme;
import com.example.drones.schemes.LoadMedicationScheme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoadMedicationInterface extends CrudRepository<LoadMedicationScheme, Long> {

    @Query(value = """
            select coalesce(sum(ms.weight),0) as weight_loaded
            from load_medication_scheme lms
                     inner join medication_scheme ms on lms.medication_id = ms.id
            where lms.drone_id=:drone_id
                               """, nativeQuery = true)
    Long getDroneLoaded(@Param("drone_id") Long drone_id);

    @Query(value = """
            select *
            from load_medication_scheme lms
            inner join drone_scheme ds on lms.drone_id = ds.id
            inner join medication_scheme ms on lms.medication_id = ms.id
                    """, nativeQuery = true)
    List<LoadMedicationScheme> getLoaded();

    List<LoadMedicationScheme> findByDroneScheme(DroneScheme droneScheme);

}
