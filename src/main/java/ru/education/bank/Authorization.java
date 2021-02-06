package ru.education.bank;

import ru.education.util.EducationUtil;

import java.util.Arrays;

public class Authorization {

    //private final String[] baseLogin = {"Dracula", "Piter", "VanDam"};
   // private final String[] basePassword = {"123", "321", "derPorol"};

     private final String[] baseLogin = EducationUtil.generateArrayString(500000);
     private final String[] basePassword = EducationUtil.generateArrayString(500000);


    public boolean auth(String login/*Dracula*/, String password/*3333*/) {
        int indexLogin = Arrays.binarySearch(baseLogin, login);
        if (indexLogin < 0) {
            return false;
        } else {
            return basePassword[indexLogin].equals(password);
        }

    }
}
