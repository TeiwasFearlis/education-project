package ru.education.algorithm.reverse;

public class Algorithm {
    /*
    * 123 -> 321
    * -123 -> -321
    * 1 -> 1
    * 123321 -> 123321
    * 2147483647 -> 0
    * */
    public int reverseValue(int number) {
        String word;
        StringBuilder result;
        String result2;
        if(number<0){
           int x=-1;
            int sum=number*x;
            word= Integer.toString (sum);
            result= new StringBuilder(word).reverse();
             result2=String.valueOf(result);
            try {
                int i = Integer.parseInt (String.valueOf(result2))*x;
                return i;
            }
            catch (NumberFormatException e){
                return 0;
            }
        }else {
            word= Integer.toString (number);
           result= new StringBuilder(word).reverse();
             result2=String.valueOf(result);
            try {
                int i = Integer.parseInt (result2);
                return i;
            }
          catch (NumberFormatException e){
                return 0;
          }

        }
    }
}
