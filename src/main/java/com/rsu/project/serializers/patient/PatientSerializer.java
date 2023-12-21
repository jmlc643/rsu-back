package com.rsu.project.serializers.patient;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientSerializer {
    @NotNull(message = "Dato nulo")
    @NotEmpty (message = "Dato vacio")
    private String name;
    @NotNull(message = "Dato nulo")
    @NotEmpty (message = "Dato vacio")
    private String surnames;
    @NotNull(message = "Dato nulo")
    @NotEmpty (message = "Dato vacio")
    private String job;
    @NotNull(message = "Dato nulo")
    @NotEmpty(message = "Dato vacio")
    private String gender;
    @NotNull(message = "Dato nulo")
    private int age;
    @NotNull(message = "Dato nulo")
    private double weight;
    @NotNull(message = "Dato nulo")
    private double size;
}
