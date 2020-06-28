package com.totemtec.repository;

import com.totemtec.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    /**
     * 说明：
     * 单向一对一关系时，findAll会执行n+1次查询
     * 双向一对一关系时，findAll会执行2n+1次查询
     * 所以需要进行覆盖，自定义Query，使用LEFT JOIN FETCH 生成 LEFT OUTER JOIN 查询
     */
    @Override
    @Query(value = "SELECT d FROM Driver d LEFT JOIN FETCH d.vehicle")
    List<Driver> findAll();
}
