package com.leonardo.ordersystem.repository;

import com.leonardo.ordersystem.entity.Portion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PortionRepository extends JpaRepository<Portion, Long> {

    @Query("SELECT a " +
            "FROM Portion a ")
    List<Portion> findPortionById(@Param("userId") Long userId);
}
