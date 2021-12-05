package com.leonardo.ordersystem.repository;

import com.leonardo.ordersystem.entity.Mustache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MustacheRepository extends JpaRepository<Mustache, Long> {
}
