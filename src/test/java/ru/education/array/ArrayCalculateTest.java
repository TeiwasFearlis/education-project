package ru.education.array;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
public class ArrayCalculateTest{

@Test
        public void test() {
    Scanner scanner = new Scanner(System.in);
    int s = Integer.MIN_VALUE;
   while (scanner.hasNextLine()){
        int x = scanner.nextInt();
        if (x % 2 == 0 && x > s) {
            s = x;
            System.out.println(s);
        }
    }
    System.out.println(s);
}
}