package com.totemtec.service;

import com.totemtec.entity.Driver;
import com.totemtec.entity.Vehicle;
import com.totemtec.repository.DriverRepository;
import com.totemtec.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MainService {

    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;

    public MainService(DriverRepository driverRepository, VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
    }

    public Driver getDriver(Long id) {
        // 自动使用 LEFT OUTER JOIN 一次全拿到
        Driver driver = driverRepository.findById(id).orElse(null);
        return driver;
    }

    public List<Driver> getDriverList() {
        // 单向一对一关系时，findAll会执行n+1次查询
        // 双向一对一关系时，findAll会执行2n+1次查询
        // 需要进行覆盖，自定义Query，使用LEFT JOIN FETCH 生成 LEFT OUTER JOIN
        return driverRepository.findAll();
    }

    public Vehicle getVehicle(Long id) {
        // 自动使用 LEFT OUTER JOIN 一次全拿到
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        return vehicle;
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getVehicleList() {
        return vehicleRepository.findAll();
    }
}
