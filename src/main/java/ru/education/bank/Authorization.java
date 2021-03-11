package ru.education.bank;

import javax.sound.sampled.AudioInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Authorization {

    final private UserRepo userRepo;

    final static HashSet<String> methodsBlackList = new HashSet<>(Arrays.asList("hack", "hack2"));

    public Authorization(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    private static String hackAnalize(Object o) {
        Class clazz = o.getClass();
        //  System.out.println("Name class " + clazz);
        //  System.out.println("Fields " + Arrays.toString(clazz.getDeclaredFields()));
        //  System.out.println("Parent " + clazz.getSuperclass());
        return Arrays.toString(clazz.getDeclaredMethods());
        //  System.out.println("Constructor " + Arrays.toString(clazz.getConstructors()));

    }

    public boolean auth(User inUser) {
        String text = Authorization.hackAnalize(inUser);
//        for (String s : Authorization.methodsBlackList) {
//            if (text.contains(s)) {
//                return false;
//            }
        // }
        Scanner sc = new Scanner(text);
        String key;
        String[] array = null;
        while (sc.hasNextLine()) {
            key = sc.nextLine();
            array = key.split("\\.");
        }
        ArrayList<String> methods = new ArrayList<>();
        for (String s : array) {
            String simbol = "(";
            if (s.contains(simbol)) {
                methods.add(s);
            }
        }
        for (String hackList : Authorization.methodsBlackList) {
            for (String str : methods) {
                if (str.contains(hackList)) {
                    return false;
                }
            }
        }
        User user = userRepo.getUser(inUser.getLogin());
        if (user != null) {
            return user.getPassword().equals(inUser.getPassword());
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Hacker hacker = new Hacker("dfg", "g");
        String text = Authorization.hackAnalize(hacker);
        Scanner sc = new Scanner(text);
        String key;
        String[] array = null;
        while (sc.hasNextLine()) {
            key = sc.nextLine();
            array = key.split("\\.");
        }
        ArrayList<String> methods = new ArrayList<>();
        int n = 0;
        for (String s : array) {
            String simbol = "(";
            if (s.contains(simbol)) {
                methods.add(s);
            }
        }
        System.out.println(methods.toString());
        for (String hackList : Authorization.methodsBlackList) {
            for (String str : methods) {
                if (str.contains(hackList)) {
                    System.out.println(str);
                }
            }
        }
    }


}

