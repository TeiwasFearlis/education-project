package ru.education.bank;

import java.io.*;
import java.util.*;

public class FileBasedUserRepo implements UserRepo {

    final File userFile;


    public FileBasedUserRepo() {
     userFile = new File("C:\\Users\\Anton\\Desktop\\Base1.txt");
    }


    @Override
    public void addNewUser(User user) {
        try {
            FileWriter file = new FileWriter(userFile,true);
            PrintWriter pw = new PrintWriter(file);
            pw.println(user.getLogin());
            pw.println(user.getPassword());
            pw.close();
        } catch ( IOException e) {
           throw new RuntimeException(e);
        }
    }
    

//    @Override
//    public User getUser(String login) {
//        try {
//            Scanner sc = new Scanner(userFile);
//            List<User> loginPasswordAll = new ArrayList<>();
//            while (sc.hasNextLine()){
//               loginPasswordAll.add(new User(sc.nextLine(),sc.nextLine()));
//            }
//            sc.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return new User();
//    }
@Override
    public User getUser(String login) {
        try {
            Scanner sc = new Scanner(userFile);
            Map<String,String> allLoginPassword = new HashMap<>();
            while (sc.hasNextLine()){
              allLoginPassword.put(sc.nextLine(),sc.nextLine());
            }
            sc.close();
            if (allLoginPassword.containsKey(login)){
                return new User(login,allLoginPassword.get(login));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    return null;
    }

public void returnString() {
    try {
        Scanner sc = new Scanner(userFile);
        List<User> loginPasswordAll = new ArrayList<>();
        while (sc.hasNextLine()){
            loginPasswordAll.add(new User(sc.nextLine(),sc.nextLine()));
        }
        sc.close();
        System.out.println(loginPasswordAll.toString());
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        FileBasedUserRepo fb = new FileBasedUserRepo();
        System.out.println(fb.getUserList());
    }

    @Override
    public List<User> getUserList() {
        List<User> loginPasswordAll = new ArrayList<>();
        try {
            Scanner sc = new Scanner(userFile);
            while (sc.hasNextLine()){
               loginPasswordAll.add(new User(sc.nextLine(),sc.nextLine()));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return loginPasswordAll;
    }

    }

