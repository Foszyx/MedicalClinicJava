package pl.foszy.medicalclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.foszy.medicalclinic.database.PatientRepository;
import pl.foszy.medicalclinic.database.Patient;
import pl.foszy.medicalclinic.model.PatientModel;

@RestController
@CrossOrigin
public class PatientAPI {

    @Autowired
    private PatientRepository patientRepository;

    //doesnt work
    @ResponseBody
    @RequestMapping("/API/testCreatePatient")
    public void createPatients2(@RequestBody Patient patient){
        patientRepository.save(new Patient(patient.getName(), patient.getSurname(), patient.getSex(), patient.getPesel()));
    }

    //work
    @ResponseBody
    @RequestMapping(path = "/API/CreatePatient", method = RequestMethod.POST)
    public void createPatient(@RequestParam("name") String name,@RequestParam("surname") String surname, @RequestParam("sex") String sex, @RequestParam("pesel") Long pesel){
        Patient patient = new Patient(name, surname, sex, pesel);
        patientRepository.save(patient);
    }

    //work
    @ResponseBody
    @RequestMapping(path = "/API/ChangeSurname", method = RequestMethod.POST)
    public void changePatientSurname(@RequestParam("newSurname") String newSurname, @RequestParam("pesel") Long pesel){
        PatientModel.changeSurname(patientRepository, pesel, newSurname);
    }

    //work
    @GetMapping("/API/getPatients")
    public Iterable<Patient> getPatients(){
        return patientRepository.findAll();
    }
}
