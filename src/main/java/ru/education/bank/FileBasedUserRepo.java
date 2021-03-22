package ru.education.bank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileBasedUserRepo implements UserRepo {

    final File userFile;


    public FileBasedUserRepo() {
        userFile = new File("loginPassword");
    }

    public FileBasedUserRepo(File file) {
        userFile = file;
    }

    public void removeOldUser(String login) {
        if (checkExist(login)) {
            File newUserFile = null;
            try (Scanner sc = new Scanner(userFile)) {
                newUserFile = new File("newFileLoginPassword");
                newUserFile.createNewFile();
                try (Writer file = new BufferedWriter(new FileWriter(newUserFile));) {
                    PrintWriter pw = new PrintWriter(file);
                    while (sc.hasNextLine()) {
                        String key = sc.nextLine();
                        if (key.startsWith(login + ";")) {
                            continue;
                        } else {
                            pw.println(key);
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                userFile.delete();
                if (newUserFile!=null && !newUserFile.renameTo(userFile)) {
                    throw new IllegalStateException("Cant rename file");
                }
            }
        } else {
            throw new IllegalStateException("User already remove!");
        }
    }


    @Override
    public void addNewUser(User user) {
        try {
            if (checkExist(user.getLogin())) {
                throw new IllegalStateException("User already exist!");
            } else {
                Writer file = new BufferedWriter(new FileWriter(userFile, true));
                PrintWriter pw = new PrintWriter(file);
                pw.println(user.getLogin() + ";" + user.getPassword()+";"+user.getBalance());
                pw.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    private boolean checkExist(String login) {
        try (Scanner sc = new Scanner(userFile)) {
            while (sc.hasNextLine()) {
                String key = sc.nextLine();
                if (key.startsWith(login + ";")) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    @Override
    public User getUser(String login) {
        try (Scanner sc = new Scanner(userFile)) {
            String key;
            while (sc.hasNextLine()) {
                key = sc.nextLine();
                if (key.startsWith(login + ";")) {
                    String[] split = key.split(";");
                    return new User(split[0], split[1], split[2] );
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public List<User> getUserList() {
        List<User> loginPasswordAll = new ArrayList<>();
        try (Scanner sc = new Scanner(userFile)) {
            while (sc.hasNextLine()) {
                String key = sc.nextLine();
                String[] split = key.split(";");
                loginPasswordAll.add(new User(split[0], split[1], split[2]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return loginPasswordAll;
    }

}

