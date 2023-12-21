package com.rsu.project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "paciente")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_paciente")
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String name;
    @Column(name = "apellidos", nullable = false)
    private String surnames;
    @Column(name = "ocupacion", nullable = false)
    private String job;
    @Column(name = "genero", nullable = false)
    private String gender;
    @Column(name = "edad", nullable = false)
    private int age;
    @Column(name = "peso", nullable = false)
    private double weight; //En Kg
    @Column(name = "talla", nullable = false)
    private double size; //En cm
}
