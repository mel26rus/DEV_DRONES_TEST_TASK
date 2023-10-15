package com.example.drones.controllers;

import com.example.drones.BaseResponse;
import com.example.drones.interfaces.DroneInterface;
import com.example.drones.interfaces.DroneModelInterface;
import com.example.drones.interfaces.DroneStateInterface;
import com.example.drones.models.Drone;
import com.example.drones.schemes.DroneScheme;
import com.example.drones.schemes.DroneModelScheme;
import com.example.drones.schemes.DroneStateScheme;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.drones.BaseResponse.*;

@RestController
@RequestMapping("/drones")
public class DroneController {


//    @Autowired
    private DroneStateInterface droneStateInterface;
//    @Autowired
    private DroneModelInterface droneModelInterface;
//    @Autowired
    private DroneInterface droneInterface;

    @GetMapping
    public BaseResponse showStatus() {
        return new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }

    public DroneController(DroneStateInterface droneStateInterface, DroneModelInterface droneModelInterface, DroneInterface droneInterface) {
//        if (this.droneStateInterface == null)
            this.droneStateInterface = droneStateInterface;
//        if (this.droneModelInterface == null)
            this.droneModelInterface = droneModelInterface;
//        if (this.droneInterface == null)
            this.droneInterface = droneInterface;
    }

    @GetMapping("/all")
    public List<DroneScheme> showDrones() {
        return (List<DroneScheme>) droneInterface.findAll();
    }

    @PostMapping("/register")
    public BaseResponse insertDrone(@RequestBody Drone drone) {
        if ((drone.getSerial_number() == null) || (drone.getModel_id() == null))
            return new BaseResponse(UNKNOWN_DATA_STATUS, CODE_ERROR_DATA);
        DroneScheme droneScheme = new DroneScheme();
        droneScheme.setBattery(drone.getBattery());
        Optional<DroneModelScheme> modelScheme = droneModelInterface.findById(drone.getModel_id());
        droneScheme.setModel(modelScheme.get());
        droneScheme.setSerial_number(drone.getSerial_number());
        droneScheme.setWeight_limit(drone.getWeight_limit());
        DroneStateScheme droneStateScheme = droneStateInterface.findByTitle("IDLE");
        droneScheme.setState(droneStateScheme);
        droneInterface.save(droneScheme);
        return new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }

    @GetMapping("/{id}")
    public Optional<DroneScheme> returnDrone(@PathVariable Long id) {
        return droneInterface.findById(id);
    }

    @GetMapping("/available")
    public List<DroneScheme> returnAvailableDrones() {
        return droneInterface.returnAvailableDrones();
    }

}
