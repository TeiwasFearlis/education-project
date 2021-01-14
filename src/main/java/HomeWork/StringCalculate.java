package HomeWork;

import javax.swing.*;
import java.util.Arrays;

public class StringCalculate {

    String[] letter = {"Bf", "Cobra", "A"};

    public StringCalculate() {
        System.out.println(Arrays.toString(letter));
    }

    public String sumLetter() {
        String sumLetter = "";
        for (int i = 0; i < letter.length; i++) {
            sumLetter += letter[i];
        }
        return sumLetter;
    }


    public String reversSumLetter() {
        return new StringBuilder(sumLetter()).reverse().toString();
    }


    public String middleLatter() {
        if (letter.length % 2 == 0) {
            return null;
        } else {
            return letter[letter.length / 2];
        }
    }


//    public String maxLetter() {
//        String maxLetter = "";
//
//        for (String x:letter) {
//            if (x > maxLetter) {
//                maxLetter = x;
//            }
//        }
//        return maxLetter;
//    }
}






