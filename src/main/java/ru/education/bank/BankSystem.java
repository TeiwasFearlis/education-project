package ru.education.bank;

import java.util.Scanner;

public class BankSystem {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String login = scanner.toString();
        System.out.print("Введите логин:"+ login);
        String password = scanner.toString();
        System.out.println("Введите пароль"+password);
    }
}
