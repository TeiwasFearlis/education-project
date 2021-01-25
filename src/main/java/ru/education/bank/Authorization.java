package ru.education.bank;

import java.util.Arrays;

public class Authorization {

    private final String[] baseLogin = {"Dracula", "Piter", "VanDam"};
    private final String[] basePassword = {"123", "321", "derPorol"};


    public boolean equalsLoginPassword(String login, String password) {
        for (String x : baseLogin)
            for (String y : basePassword)
                if (x.equals(login) && y.equals(password)) {
                    return true;
                }
        return false;
    }


    public boolean auth(String login, String password) {
        int oneKey;
        int twoKey;
        if (equalsLoginPassword(login, password)) {
            oneKey = Arrays.binarySearch(baseLogin, login);
            twoKey = Arrays.binarySearch(basePassword, password);
            return oneKey == twoKey;
        }
        return false;
    }
}
