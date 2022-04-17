package pl.foszy.medicalclinic.model;
import pl.foszy.medicalclinic.database.Patient;
import pl.foszy.medicalclinic.database.PatientRepository;

import java.util.Optional;

public class PatientModel {
    public static void changeSurname(PatientRepository patientRepository, Long pesel, String newSurname){
        Optional<Patient> findPatient = patientRepository
                .findById(findByPesel(patientRepository, pesel));
        if(findPatient != null) {
            Patient patient = findPatient.get();
            patient.setSurname(newSurname);
            patientRepository.save(patient);
            System.out.println("Change surname is succesfully.");
        }
        System.out.println("Can't find patient.");
    }

    private static Long findByPesel(PatientRepository patientRepository, Long pesel){
        Long[] id = new Long[1];
        Iterable<Patient> allPatients = patientRepository.findAll();
        allPatients.forEach(patientDatabase -> {
            if(patientDatabase.getPesel().equals(pesel)){
                id[0] = patientDatabase.getID();
            }
        });
        return id[0];
    }
}
