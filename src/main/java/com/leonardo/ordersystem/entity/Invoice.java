package com.leonardo.ordersystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "nit", nullable = false)
    private String nit;

    @Column(name = "invoiceDate", nullable = false)
    private LocalDate invoiceDate;
}
