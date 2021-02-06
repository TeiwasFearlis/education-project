package ru.education.util;

import java.util.Random;

public class EducationUtil {

    private static char[] alph = generateAlph();

    private static char[] generateAlph(){
        char[] m = new char[26];
        for (int i = 0; i < 26; i++) {
            m[i] = (char) ('a' + i);
        }
        return m;
    }

    public static String generateString(){
        Random random = new Random();
        int size = random.nextInt(10);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(alph[random.nextInt(26)]);
        }
        return builder.toString();
    }

    public static String[] generateArrayString(int index){
        String[] letter = new String[index];
        for (int i = 0; i < index; i++) {
            letter[i] = generateString();
        }
        return letter;
    }

}
