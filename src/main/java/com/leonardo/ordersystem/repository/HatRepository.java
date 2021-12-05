package com.leonardo.ordersystem.repository;

import com.leonardo.ordersystem.entity.Hat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HatRepository extends JpaRepository<Hat, Long> {
}
