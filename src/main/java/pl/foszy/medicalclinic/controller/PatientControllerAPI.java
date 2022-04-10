package pl.foszy.medicalclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.foszy.medicalclinic.database.PatientRepositoryDatabase;
import pl.foszy.medicalclinic.database.PatientDatabase;
import pl.foszy.medicalclinic.model.PatientModel;

@RestController
@CrossOrigin
public class PatientControllerAPI {

    @Autowired
    private PatientRepositoryDatabase patientRepositoryDatabase;

    @GetMapping("/API/createPatient")
    public void createPatient(String name, String surname, String sex, Long pesel){
        PatientDatabase patientDatabase = new PatientDatabase("Andzerj", "sraka", "Female", 12345677L);
        patientRepositoryDatabase.save(patientDatabase);
    }

    @GetMapping("/API/getPatients")
    public Iterable<PatientDatabase> getPatients(){
        PatientModel.changeSurname(patientRepositoryDatabase, 1L, "Kasztani");
        return patientRepositoryDatabase.findAll();
    }
}
