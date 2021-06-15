package ru.education.shapes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Program {
    private static java.util.stream.Collectors Collectors;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        char[] arr = text.toCharArray();
        char[] revers = new char[arr.length];
        for (int x = arr.length - 1; x >= 0; x--) {
            int t = 0;
            revers[t++] = arr[x];

            System.out.print(revers);
        }
    }
}


