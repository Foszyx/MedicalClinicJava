package pl.foszy.medicalclinic.security;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCreatePatient {

    public static boolean stringDataIsCorrect(String data){
        try{
            if(data.trim().equals("")){
                return false;
            }
            Pattern pattern = Pattern.compile("[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]");
            char[] checkData = data.trim().toCharArray();
            for(int i = 0; i < checkData.length; i++){
                Matcher matcher = pattern.matcher(Character.toString(checkData[i]));
                if(!matcher.matches()){
                    return false;
                }
            }
            return true;
        }catch(NullPointerException e){
                System.out.print(e.getClass().getName());
                return false;
            }

    }

    public static boolean peselIsCorrect(Long pesel){
        try{
            String checkPesel = pesel.toString();
            if(checkPesel.length() == 11){
                return true;
            }
            return false;
        }catch(NullPointerException e){
            System.out.println(e.getClass().getName());
            return false;
        }
    }

    public static String upperFirstLetter(String word){
        String start = word.trim().substring(0, 1).toUpperCase();
        String end = word.trim().substring(1).toLowerCase();
        return start+end;
    }
}
