package com.rsu.project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ficha_paciente")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ficha")
    private Long id;
    @Column(name = "imc", nullable = false)
    private double imc;
    @Column(name = "observacion")
    private String observation;

    @JoinColumns({
            @JoinColumn(name="id_paciente", referencedColumnName="id_paciente", nullable = false)
    })
    @ManyToOne
    private Patient patient;

}
