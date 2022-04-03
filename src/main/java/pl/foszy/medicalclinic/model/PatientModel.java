package pl.foszy.medicalclinic.model;

import pl.foszy.medicalclinic.database.PatientDatabase;
import pl.foszy.medicalclinic.database.PatientRepositoryDatabase;

import java.util.Optional;

public class PatientModel {

    PatientRepositoryDatabase patientRepositoryDatabase;

    public void changeSurname(Long ID){
        patientRepositoryDatabase.findById(ID);
    }
}
