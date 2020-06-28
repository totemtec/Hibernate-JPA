package com.totemtec.repository;

import com.totemtec.entity.Driver;
import com.totemtec.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    /**
     * 说明：
     * 从关系配角发起的findAll会执行n+1次查询
     * 所以需要进行覆盖，自定义Query，使用LEFT JOIN FETCH 生成 LEFT OUTER JOIN 查询
     */
//    @Override
//    @Query(value = "SELECT v FROM Vehicle v LEFT JOIN FETCH v.driver")
    List<Vehicle> findAll();
}
