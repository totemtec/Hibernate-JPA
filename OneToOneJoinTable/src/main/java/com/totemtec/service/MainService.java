package com.totemtec.service;

import com.totemtec.entity.Employee;
import com.totemtec.entity.WorkStation;
import com.totemtec.repository.EmployeeRepository;
import com.totemtec.repository.WorkStationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MainService {

    private final EmployeeRepository employeeRepository;
    private final WorkStationRepository workStationRepository;

    public MainService(EmployeeRepository employeeRepository,
                       WorkStationRepository workStationRepository) {

        this.employeeRepository = employeeRepository;
        this.workStationRepository = workStationRepository;
    }

    @Transactional
    public Employee newEmployeeAndWorkStation () {
        Employee employee = new Employee();
        employee.setName("马江林");

        WorkStation workStation = new WorkStation();
        workStation.setWorkstationNumber(888);
        workStation.setFloor("11层");

        employee.setWorkStation(workStation);
        workStation.setEmployee(employee);

        employee = employeeRepository.save(employee);
        return employee;
    }

    @Transactional
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }


}
