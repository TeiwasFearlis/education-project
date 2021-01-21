package ru.education.bank;

import java.util.Arrays;
import java.util.Scanner;

public class BankSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter login: ");
        var login = scanner.nextLine();
        System.out.print("Enter password: ");
        var password = scanner.nextLine();
        var base = new Authorization();
        Integer oneKey = Arrays.binarySearch(base.baseLogin, login);
        System.out.println("индекс логина: " + oneKey);
        Integer twoKey = Arrays.binarySearch(base.basePassword, password);
        System.out.println("индекс пароля: " + twoKey);
        if (oneKey == twoKey) {
            System.out.println("Молодец!");
        } else {
            System.out.println("Неверный логин или пароль");

        }
    }
}