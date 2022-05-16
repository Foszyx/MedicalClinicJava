package pl.foszy.medicalclinic.security;

public class CheckCreatePatient {
    private String name;
    private String surname;
    private String sex;
    private Long pesel;

    public CheckCreatePatient(String name, String surname, String sex, Long pesel) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.pesel = pesel;
    }

    public static boolean dataIsCorrect(){
        return false;
    }
}
