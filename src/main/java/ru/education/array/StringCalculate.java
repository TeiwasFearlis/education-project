package ru.education.array;

import java.util.Arrays;
import java.util.Random;

public final class StringCalculate {

    public final String[] letter;

    private String alphabetRandomLetter() {
        char[] m = new char[26];
        Random random = new Random();
        for (int i = 0; i < 26; i++) {
            m[i] = (char) ('a' + i);// не знаю как работает(('a'+1) это 'b' ? ,а ('a'+2) это 'c'?
        }
        int size = random.nextInt(10);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(m[random.nextInt(26)]);
        }
        return builder.toString();
    }

    public StringCalculate(int index) {
        letter = new String[index];
        for (int i = 0; i < index; i++) {
            letter[i] = alphabetRandomLetter();
        }
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





