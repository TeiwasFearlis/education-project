package ru.education.bank;

import ru.education.util.EducationUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Authorization {

    private final String[] baseLogin = {"Vfgh","fix", "Dracula", "Piter", "VanDam", "Cot"};
    private final String[] basePassword = {"321","fix", "123", "456", "derPorol", "durak"};
    ArrayList<String> baseLoginString = new ArrayList<String>(Arrays.asList(baseLogin));
    ArrayList<String> basePasswordString = new ArrayList<String>(Arrays.asList(basePassword));
    //  private final String[] baseLogin = EducationUtil.generateArrayString(500000);
    // private final String[] basePassword = EducationUtil.generateArrayString(500000);


    public boolean auth(String login, String password) {
        int indexLogin = baseLoginString.indexOf(login);
        if (indexLogin < 0) {
            return false;
        } else {
            return basePasswordString.get(indexLogin).equals(password);
        }




//    public boolean auth(String login, String password) {
//        for (int i = 0; i < login.length(); i++) {
//            int x=login.length();
//           if( baseLogin[i].equals(login)) {
//               int index = i;
//               return basePassword[index].equals(password);
//           }
//            }
//        return false;
//        }


//    public boolean auth(String login, String password) {
//            int indexLogin = Arrays.binarySearch(baseLogin, login);
//        if (indexLogin < 0) {
//            return false;
//        } else {
//            return basePassword[indexLogin].equals(password);
//        }


    }

}