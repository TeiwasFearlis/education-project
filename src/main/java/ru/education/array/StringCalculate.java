package ru.education.array;

import ru.education.util.EducationUtil;

import java.util.Arrays;
import java.util.Random;

public final class StringCalculate {

    public final String[] letter;

    public StringCalculate(int index) {
        letter = EducationUtil.generateArrayString(index);
        System.out.println("Array:" + Arrays.toString(letter));
    }

    public StringCalculate(String[] userTester) {
        letter = userTester;
    }


    public String sumLetter() {
        StringBuilder sumLetter = new StringBuilder();
        for (String s : letter) {
            sumLetter.append(s);
        }
        return sumLetter.toString();
    }


    public String reversSumLetter() {
        //return new StringBuilder(sumLetter()).reverse().toString();
        char[] result = sumLetter().toCharArray();
        StringBuilder reversLetter = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            reversLetter.append(result[i]);//TODO read about this
        }
        return reversLetter.toString();
    }



    public String middleLatter() {
        if (letter.length % 2 == 0) {
            return null;
        } else {
            return letter[letter.length / 2];
        }
    }


    public String maxSizeString() {
        String maxString = null;
        for (String s : letter) {
            if (maxString == null) {
                maxString = s;
            } else if (s.length() > maxString.length()) {
                maxString = s;
            }
        }
        return maxString;



    }

}





