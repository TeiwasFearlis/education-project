package ArrayCalculate;

import java.util.Arrays;

public class HomeWork {

    public static void main(String[] args) {
        ArrayCalculate calculate = new ArrayCalculate(5);
        System.out.println("Middle:"+calculate.middle());
        System.out.println("Max:"+calculate.max());
        System.out.println("Reverse:"+ Arrays.toString(calculate.revers()));
        System.out.println("Sum:"+calculate.sum());

    }
}




