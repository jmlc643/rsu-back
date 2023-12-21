package com.rsu.project.serializers.patient_file;

import com.rsu.project.serializers.patient.PatientSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientFileSerializer {
    private Long id;
    private double imc;
    private String observation;
    private PatientSerializer patient;
}