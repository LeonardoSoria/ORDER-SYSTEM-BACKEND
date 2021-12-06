package com.leonardo.ordersystem.repository;

import com.leonardo.ordersystem.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
