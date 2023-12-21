package com.rsu.project.controllers;

import com.rsu.project.models.PatientFile;
import com.rsu.project.serializers.patient.PatientSerializer;
import com.rsu.project.serializers.patient_file.PatientFileSerializer;
import com.rsu.project.services.PatientFileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient-file")
@CrossOrigin(origins = "https://joyful-creponne-d019b0.netlify.app")
public class PatientFileController {
    @Autowired
    private PatientFileService patientFileService;

    @GetMapping("/list/")
    public List<PatientFileSerializer> getPatientFiles(){
        return patientFileService.listPatientFiles().stream().map((it) -> patientFileService.returnPatientFile(it)).toList();
    }

    @PostMapping("/save/")
    public PatientFile savePatientFile(@Valid @RequestBody PatientSerializer request){
        return patientFileService.savePatientFile(request);
    }

    @PostMapping("/search/id/")
    public PatientFileSerializer searchPatientFileId(@Valid @RequestBody Long request){
        return patientFileService.searchPatientFileId(request);
    }
}
