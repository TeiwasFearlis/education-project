package ru.education.bank;

import ru.education.util.EducationUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Authorization {

    ArrayList<String> baseLoginString = new ArrayList<>(Arrays.asList("Vfgh","fix", "Dracula", "Piter", "VanDam", "Cot"));
    ArrayList<String> basePasswordString = new ArrayList<>(Arrays.asList("321","fix", "123", "456", "derPorol", "durak"));
    //  private final String[] baseLogin = EducationUtil.generateArrayString(500000);
    // private final String[] basePassword = EducationUtil.generateArrayString(500000);


    public boolean auth(String login, String password) {
        int indexLogin = baseLoginString.indexOf(login);
        if (indexLogin < 0) {
            return false;
        } else {
            return basePasswordString.get(indexLogin).equals(password);
        }
    }

}