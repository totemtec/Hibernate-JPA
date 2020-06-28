package com.totemtec.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Vehicle implements Serializable {

    @Id
    private Long id;

    private String license;

    // 这边再映射的话就是双向关系
    @OneToOne
    @MapsId
//    @JoinColumn(name = "driver_id")  //这个可以根据 对象名_id 自动来判断
    private Driver driver;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", license='" + license + '\'' +
                ", driver=" + driver +
                '}';
    }
}
