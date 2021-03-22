package ru.education.bank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUserBalance implements UserBalanceRepo {

    final File userBalance;


    public FileUserBalance() {
        userBalance = new File("userBalance");
    }

    public FileUserBalance(File file) {
        userBalance = file;
    }



    @Override
    public void addUserBalance(User user) throws IllegalStateException {
        try {
            if (checkExistBalance(user.getLogin())) {
                throw new IllegalStateException("User already exist!");
            } else {
                Writer file = new BufferedWriter(new FileWriter(userBalance, true));
                PrintWriter pw = new PrintWriter(file);
                pw.println(user.getLogin() + ";" + user.getBalance());
                pw.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserBalance(String login) {
        if (checkExistBalance(login)) {
            File newUserFile = null;
            try (Scanner sc = new Scanner(userBalance)) {
                newUserFile = new File("newFileUserBalance");
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
            } finally {
                userBalance.delete();
                if (newUserFile != null && !newUserFile.renameTo(userBalance)) {
                    throw new IllegalStateException("Cant rename file");
                }
            }
        } else {
            throw new IllegalStateException("User is not exist!");
        }


    }

    private boolean checkExistBalance(String login) {
        try (Scanner sc = new Scanner(userBalance)) {
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


    public String getUserBalance(String login) {
        try (Scanner sc = new Scanner(userBalance)) {
            String key;
            while (sc.hasNextLine()) {
                key = sc.nextLine();
                if (key.startsWith(login + ";")) {
                    String[] split = key.split(";");
                    return split[1];
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args) {
        FileUserBalance f = new FileUserBalance();
        System.out.println( f.getUserBalance("123"));
    }


    public List<User> getUserBalanceList() {
        List<User> loginPasswordAll = new ArrayList<>();
        try (Scanner sc = new Scanner(userBalance)) {
            while (sc.hasNextLine()) {
                String key = sc.nextLine();
                String[] split = key.split(";");
                loginPasswordAll.add(new User(split[0], split[1],split[2]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return loginPasswordAll;
    }


}

