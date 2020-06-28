package com.totemtec;

import com.totemtec.entity.Driver;
import com.totemtec.entity.Vehicle;
import com.totemtec.repository.VehicleRepository;
import com.totemtec.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class MainApplication {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.exit(0);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            // 自动使用 LEFT OUTER JOIN 一次全拿到
//            Driver driver = driverRepository.findById(1L).orElse(null);
//            System.out.println("driver : " + driver);
//            Vehicle vehicle = driver.getVehicle();
//            System.out.println("vehicle : " + vehicle);

            // 单向一对一关系时，findAll会执行n+1次查询
            // 双向一对一关系时，findAll会执行2n+1次查询
            // 需要进行覆盖，自定义Query，使用LEFT JOIN FETCH 生成 LEFT OUTER JOIN
//            List<Driver> drivers = driverRepository.findAll();
//            drivers.forEach(driver -> {
//                System.out.println("driver : " + driver);
//            });

//            Vehicle vehicle = vehicleRepository.findById(20L).orElse(null);
//            System.out.println("vehicle : " + vehicle);
//            System.out.println("driver : " + vehicle.getDriver());

            List<Vehicle> vehicleList = vehicleRepository.findAll();
            for (Vehicle vehicle : vehicleList) {
                System.out.println("vehicle : " + vehicle);
                System.out.println("driver : " + vehicle.getDriver());
            }

        };
    }
}
