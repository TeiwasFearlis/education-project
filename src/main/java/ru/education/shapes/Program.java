package ru.education.shapes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Program {
    private static java.util.stream.Collectors Collectors;

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//
//        Square a = new Square(x);
//        Circle b = new Circle(y);
//        a.area();
//        b.area();


//        char[] m = new char[26];
//        for (int i=0; i< 26; i++) {
//            m[i] = (char)('a' + i);
//        }
//        System.out.println(Arrays.toString(m));

//        int amount = 20000;
//        //введите код сюда
//        int vozvrat ;
//        int ost;
//        for (int j = 0; j <6 ; j++) {
//            vozvrat=(amount*10)/100;
//            amount= amount - vozvrat ;
//
//        }
//        System .out.println (amount);

                Scanner scanner = new Scanner(System.in);
                String text = scanner.nextLine();
                char[] arr = text.toCharArray();
                char [] revers=new char [arr.length];
                for(int x=arr.length-1;x>=0;x--){
                    int t=0;
                    revers[t++] =arr[x];

                    System.out.print(revers);
            }
        }
    }


