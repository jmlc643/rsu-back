package com.rsu.project.services;

import com.rsu.project.models.Patient;
import com.rsu.project.repositories.PatientRepository;
import com.rsu.project.serializers.patient.PatientSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public List<Patient> listPatients(){return patientRepository.findAll();}

    public Patient savePatient(Patient patient){return patientRepository.save(patient);}

    public PatientSerializer returnPatient(Patient patient){
        return new PatientSerializer(patient.getName(), patient.getSurnames(), patient.getJob(), patient.getGender(), patient.getAge(), patient.getWeight(), patient.getSize());
    }
}
