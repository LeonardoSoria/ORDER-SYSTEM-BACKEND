package com.leonardo.ordersystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "mouths")
public class Mouth {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;
}
