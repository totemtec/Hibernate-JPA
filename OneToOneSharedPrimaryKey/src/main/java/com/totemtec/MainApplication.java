package com.totemtec;

import com.totemtec.entity.Driver;
import com.totemtec.entity.Vehicle;
import com.totemtec.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class MainApplication {

    @Autowired
    private MainService mainService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.exit(0);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
//            mainService.newDriverAndVehicle();

            mainService.newVehicleForDriver(1L);

//            List<Driver> driverList = mainService.getDriverList();
//            driverList.forEach(driver -> {
//                System.out.println(driver);
//            });

//            List<Vehicle> vehicleList = mainService.getVehicleList();
//            vehicleList.forEach(vehicle -> {
//                System.out.println(vehicle);
//                System.out.println(vehicle.getDriver());
//            });

        };
    }
}
