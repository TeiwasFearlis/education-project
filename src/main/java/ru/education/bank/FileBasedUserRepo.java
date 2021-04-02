package ru.education.bank;

import ru.education.bank.Admin.Admin;
import ru.education.bank.Admin.AdminOperationAdapter;
import ru.education.bank.SimpleUser.SimpleUser;
import ru.education.bank.SimpleUser.UserOperationAdapter;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
                try (Writer file = new BufferedWriter(new FileWriter(newUserFile));) {//TODO нужен ли тут второй try?
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
                userFile.delete();
                if (newUserFile != null && !newUserFile.renameTo(userFile)) {
                    throw new IllegalStateException("Cant rename file");
                }
            }
        } else {
            throw new IllegalStateException("User already remove!");
        }
    }


    @Override
    public void addNewUser(IUser user) {
        try {
            if (checkExist(user.getLogin())) {
                throw new IllegalStateException("User already exist!");
            } else {
                Writer file = new BufferedWriter(new FileWriter(userFile, true));
                PrintWriter pw = new PrintWriter(file);
                PersonType type = user.getPerson();
                switch (type) {
                    case ADMIN:
                        pw.println(user.getLogin() + ";" + user.getPassword() + ";" + "" + ";" + user.getPerson());
                        pw.close();
                        break;
                    case SIMPLE_USER:
                        pw.println(user.getLogin() + ";" + user.getPassword() + ";" + user.getBalance() + ";" + user.getPerson());
                        pw.close();
                        break;
                }
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
    public IUser getUser(String login) {
        try (Scanner sc = new Scanner(userFile)) {
            String key;
            while (sc.hasNextLine()) {
                key = sc.nextLine();
                if (key.startsWith(login + ";")) {
                    String[] split = key.split(";");
                    String userType = split[3];
                    PersonType type = PersonType.valueOf(userType);
                    switch (type) {
                        case ADMIN:
                            return new Admin(split[0],
                                    split[1],
                                    new AdminOperationAdapter(this));
                        case SIMPLE_USER:
                            return new SimpleUser(split[0],
                                    split[1],
                                    BigDecimal.valueOf(Double.parseDouble(split[2])).setScale(2, RoundingMode.HALF_UP),
                                    new UserOperationAdapter(this));
                        default:
                            throw new IllegalStateException("");

                    }
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public List<IUser> getUserList() {
        List<IUser> loginPasswordAll = new ArrayList<>();
        try (Scanner sc = new Scanner(userFile)) {
            while (sc.hasNextLine()) {
                String key = sc.nextLine();
                String[] split = key.split(";");
                loginPasswordAll.add(new SimpleUser(split[0],
                        split[1],
                        BigDecimal.valueOf(Double.parseDouble(split[2])).setScale(2, RoundingMode.HALF_UP),
                        new UserOperationAdapter(this)));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return loginPasswordAll;
    }

}

