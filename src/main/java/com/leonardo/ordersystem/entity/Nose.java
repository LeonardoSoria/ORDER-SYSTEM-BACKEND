package com.leonardo.ordersystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "nose")
public class Nose {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

}
