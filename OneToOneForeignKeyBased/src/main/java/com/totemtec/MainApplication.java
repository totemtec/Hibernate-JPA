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

//            Driver driver = mainService.createDriverAndVehicle();
//            System.out.println(driver);

            Driver driver = mainService.createVehicleForDriver(1L);
            System.out.println(driver);


//            Driver driver = mainService.getDriver(1L);
//            System.out.println("driver : " + driver);
//            Vehicle vehicle = driver.getVehicle();
//            System.out.println("vehicle : " + vehicle);


//            List<Driver> drivers = mainService.getDriverList();
//            drivers.forEach(driver -> {
//                System.out.println("driver2 : " + driver);
//            });

//            Vehicle vehicle = mainService.getVehicle(20L);
//            System.out.println("vehicle : " + vehicle);
//            System.out.println("driver : " + vehicle.getDriver());

//            List<Vehicle> vehicleList = mainService.getVehicleList();
//            for (Vehicle vehicle : vehicleList) {
//                System.out.println("vehicle : " + vehicle);
//                System.out.println("driver : " + vehicle.getDriver());
//            }
        };
    }
}
