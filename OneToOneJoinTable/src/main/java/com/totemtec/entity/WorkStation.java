package com.totemtec.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class WorkStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer workstationNumber;

    private String floor;

    @OneToOne(mappedBy = "workStation")
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWorkstationNumber() {
        return workstationNumber;
    }

    public void setWorkstationNumber(Integer workstationNumber) {
        this.workstationNumber = workstationNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "WorkStation{" +
                "id=" + id +
                ", workstationNumber=" + workstationNumber +
                ", floor='" + floor + '\'' +
//                ", employee=" + employee +
                '}';
    }
}