package com.totemtec;

import com.totemtec.repository.VehicleRepository;
import com.totemtec.repository.DriverRepository;
import com.totemtec.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MainApplication {

    @Autowired
    private VehicleService vehicleService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.exit(0);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            vehicleService.newVehicleOfDriver();
        };
    }
}
