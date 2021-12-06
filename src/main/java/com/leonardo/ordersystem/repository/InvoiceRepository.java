package com.leonardo.ordersystem.repository;

import com.leonardo.ordersystem.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
