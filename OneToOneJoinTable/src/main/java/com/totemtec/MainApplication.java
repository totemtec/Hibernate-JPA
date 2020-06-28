package com.totemtec;

import com.totemtec.entity.Employee;
import com.totemtec.repository.WorkStationRepository;
import com.totemtec.repository.EmployeeRepository;
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
            // 插入数据
//            Employee employee = mainService.newEmployeeAndWorkStation();
//            System.out.println(employee);

            // 读取数据
            List<Employee> employeeList = mainService.getEmployeeList();
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        };
    }
}
