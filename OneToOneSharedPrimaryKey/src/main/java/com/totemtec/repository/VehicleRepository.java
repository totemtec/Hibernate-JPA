package com.totemtec.repository;

import com.totemtec.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Override
    @Query(value = "SELECT v FROM Vehicle v LEFT JOIN FETCH v.driver")
    List<Vehicle> findAll();
}
