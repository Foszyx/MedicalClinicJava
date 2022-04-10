package pl.foszy.medicalclinic.model;
import pl.foszy.medicalclinic.database.PatientDatabase;
import pl.foszy.medicalclinic.database.PatientRepositoryDatabase;

import java.util.Optional;

public class PatientModel {
    public static void changeSurname(PatientRepositoryDatabase patientRepositoryDatabase, Long id, String newSurname){
        Optional<PatientDatabase> findPatient = patientRepositoryDatabase.findById(id);
        PatientDatabase patient = findPatient.get();
        patient.setSurname(newSurname);
        patientRepositoryDatabase.save(patient);
    }

    private static Long findByPesel(PatientRepositoryDatabase patientRepositoryDatabase, Long pesel){
        Long[] id = new Long[1];
        Iterable<PatientDatabase> allPatients = patientRepositoryDatabase.findAll();
        allPatients.forEach(patientDatabase -> {
            if(patientDatabase.getPesel().equals(pesel)){
                id[0] = patientDatabase.getID();
            }
        });
        return id[0];
    }
}
