package HomeWork;

import java.util.Arrays;
import java.util.Random;

public class StringCalculate {


    public final String[] letter;



    public String alphabetRandomLetter() {
        char[] m = new char[26];
        Random random = new Random();
        for (int i = 0; i < 26; i++) {
            m[i] = (char) ('a' + i);// не знаю как работает(('a'+1) это 'b' ? ,а ('a'+2) это 'c'?
        }
       String  randomLetter = new String(m, 0, random.nextInt(26));
        return randomLetter;
    }

    public StringCalculate(int index) {
        letter = new String[index];
        for (int i = 0; i < index; i++) {
            letter[i] = alphabetRandomLetter();
        }
        System.out.println("Array:" + Arrays.toString(letter));
    }

    public StringCalculate(String[] userTester) { // непонятен смысл юзерского конструкта, как им пользоваться?
        letter = userTester;
    }


    public String sumLetter() {
        String sumLetter = "";
        for (int i = 0; i < letter.length; i++) {
            sumLetter += letter[i];
        }
        return sumLetter;
    }


    public String reversSumLetter() {
        //return new StringBuilder(sumLetter()).reverse().toString();
        char[] result = sumLetter().toCharArray();
        String reversLetter = "";
        for (int i = result.length - 1; i >= 0; i--) {
            reversLetter += result[i];
        }
        return reversLetter;
    }



    public String middleLatter() {
        if (letter.length % 2 == 0) {
            return null;
        } else {
            return letter[letter.length / 2];
        }
    }


    public String maxLetter() {
        int maxLet = 0;
        String maxLetter = null;
        for (int i = 0; i < letter.length; i++) {
            if (letter[i].length() > maxLet) {
                maxLet = letter[i].length();
                maxLetter = letter[i];
            }
        }
        return maxLetter;
    }

}





