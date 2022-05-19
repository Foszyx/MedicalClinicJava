package pl.foszy.medicalclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.foszy.medicalclinic.database.PatientRepository;
import pl.foszy.medicalclinic.database.Patient;
import pl.foszy.medicalclinic.model.PatientModel;
import pl.foszy.medicalclinic.security.CheckCreatePatient;

@RestController
@CrossOrigin
public class PatientAPI {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/API/createPatient")
    public void createPatient(@RequestParam("name") String name,@RequestParam("surname") String surname, @RequestParam("sex") String sex, @RequestParam("pesel") Long pesel){
        if(CheckCreatePatient.stringDataIsCorrect(name) &&
           CheckCreatePatient.stringDataIsCorrect(surname) &&
           CheckCreatePatient.stringDataIsCorrect(sex) &&
           CheckCreatePatient.peselIsCorrect(pesel)){
                Patient patient = new Patient(CheckCreatePatient.upperFirstLetter(name),
                                              CheckCreatePatient.upperFirstLetter(surname),
                                              CheckCreatePatient.upperFirstLetter(sex),
                                              pesel);
                patientRepository.save(patient);
        }
    }

    @PutMapping("/API/changeSurname")
    public void changePatientSurname(@RequestParam("newSurname") String newSurname, @RequestParam("pesel") Long pesel){
        if(CheckCreatePatient.peselIsCorrect(pesel) && CheckCreatePatient.stringDataIsCorrect(newSurname)) {
            PatientModel.changeSurname(patientRepository, pesel, newSurname);
        }
    }

    @GetMapping("/API/getPatients")
    public Iterable<Patient> getPatients(){
        return patientRepository.findAll();
    }
}
