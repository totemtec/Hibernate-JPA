package com.totemtec.service;

import com.totemtec.entity.Driver;
import com.totemtec.entity.Vehicle;
import com.totemtec.repository.DriverRepository;
import com.totemtec.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MainService {

    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;

    public MainService(DriverRepository driverRepository,
                       VehicleRepository vehicleRepository) {

        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
    }

    @Transactional
    public void newDriverAndVehicle () {
        Driver driver = new Driver();
        driver.setUserName("那谁谁");

        Vehicle vehicle = new Vehicle();
        vehicle.setLicense("京SDF123");

        vehicle.setDriver(driver);
        driver.setVehicle(vehicle);

        driverRepository.save(driver);
        vehicleRepository.save(vehicle);
    }

    public List<Driver> getDriverList() {
        return driverRepository.findAll();
    }

    public List<Vehicle> getVehicleList() {
        //默认是n+1次查询
        return vehicleRepository.findAll();
    }

    @Transactional
    public void newVehicleForDriver(Long driverId) {

        Driver driver = driverRepository.findById(driverId).orElseThrow(RuntimeException::new);

        Vehicle vehicle = new Vehicle();
        vehicle.setLicense("冀FSL670");
        vehicle.setDriver(driver);

        vehicleRepository.save(vehicle);

        //如果这里不setVehicle，新增后的Vehicle跟这个driver没关联
        driver.setVehicle(vehicle);
    }

}
