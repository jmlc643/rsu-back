package com.rsu.project.services;

import com.rsu.project.models.Patient;
import com.rsu.project.models.PatientFile;
import com.rsu.project.repositories.PatientFileRepository;
import com.rsu.project.serializers.patient.PatientSerializer;
import com.rsu.project.serializers.patient_file.PatientFileSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientFileService {
    @Autowired
    private PatientFileRepository patientFileRepository;

    @Autowired  private PatientService patientService;

    public List<PatientFile> listPatientFiles(){return patientFileRepository.findAll();}

    public PatientFile savePatientFile(PatientSerializer request){
        Patient patient = new Patient(null, request.getName(), request.getSurnames(), request.getJob(), request.getGender(), request.getAge(), request.getWeight(), request.getSize());
        patientService.savePatient(patient);
        PatientFile patientFile = new PatientFile(null, calculateIMC(patient), generateObservation(calculateIMC(patient)), patient);
        return patientFileRepository.save(patientFile);
    }

    public PatientFileSerializer returnPatientFile(PatientFile patientFile){
        return new PatientFileSerializer(patientFile.getId(), patientFile.getImc(), patientFile.getObservation(), patientService.returnPatient(patientFile.getPatient()));
    }

    private String generateObservation(double imc) {
        if(imc < 18.5){
            return "Peso demasiado bajo";
        }
        if(imc >= 18.5 && imc <= 24.9){
            return "Peso normal";
        }
        if(imc >= 25 && imc <= 29.9){
            return "Sobrepeso";
        }
        if(imc >= 30){
            return "Obesidad";
        }
        return "Datos mal ingresados";
    }

    private double calculateIMC(Patient patient){
        return patient.getWeight()/(Math.pow(patient.getSize(), 2));
    }

    public PatientFileSerializer searchPatientFileId(Long request) {
        Optional<PatientFile> patientFile = patientFileRepository.findById(request);
        if(patientFile.isEmpty()){
            throw new RuntimeException("Ficha no encontrada");
        } return returnPatientFile(patientFile.get());
    }
}
