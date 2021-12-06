package com.leonardo.ordersystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "totalAmount", nullable = false)
    private Double totalAmount;

    @Column(name = "saleDate", nullable = false)
    private LocalDate saleDate;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "invoiceId", updatable = false)
    @JsonBackReference
    private Invoice invoice;
}
