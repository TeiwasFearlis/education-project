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
        if(number<0){
           int x=-1;
            int sum=number*x;
            word= Integer.toString (sum);
            result= new StringBuilder(word).reverse();
            try {
                return  Integer.parseInt (String.valueOf(result))*x;

            }
            catch (NumberFormatException e){
                return 0;
            }
        }else {
            word= Integer.toString (number);
           result= new StringBuilder(word).reverse();
            try {
                return Integer.parseInt (String.valueOf(result));

            }
          catch (NumberFormatException e){
                return 0;
          }

        }
    }
}
