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
@Table(name = "eyes")
public class Eye {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;
}
