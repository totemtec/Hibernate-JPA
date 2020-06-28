package com.totemtec.service;

import com.totemtec.entity.Driver;
import com.totemtec.entity.Vehicle;
import com.totemtec.repository.DriverRepository;
import com.totemtec.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class VehicleService {

    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;

    public VehicleService(DriverRepository driverRepository,
                          VehicleRepository vehicleRepository) {

        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
    }

    @Transactional
    public void newVehicleOfDriver() {

        Driver driver = driverRepository.findById(2L).orElseThrow(RuntimeException::new);

        Vehicle vehicle = new Vehicle();
        vehicle.setLicense("冀FSL670");
        vehicle.setDriver(driver);

        vehicleRepository.save(vehicle);
    }

}
