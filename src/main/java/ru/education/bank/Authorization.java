package ru.education.bank;

import ru.education.util.EducationUtil;

import java.util.Arrays;

public class Authorization {

    private final String[] baseLogin = {"V", "Dracula", "Piter", "VanDam", "Van"};
    private final String[] basePassword = {"321", "123", "321", "derPorol", "123"};

    //  private final String[] baseLogin = EducationUtil.generateArrayString(500000);
    // private final String[] basePassword = EducationUtil.generateArrayString(500000);


    public boolean auth(String login, String password) {
        int indexLogin = Arrays.binarySearch(baseLogin, login);
        if (indexLogin < 0) {
            return false;
        } else {
            return basePassword[indexLogin].equals(password);
        }

    }
}
