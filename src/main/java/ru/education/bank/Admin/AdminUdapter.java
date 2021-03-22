package ru.education.bank.Admin;

import ru.education.bank.FileBasedUserRepo;
import ru.education.bank.User;

public class AdminUdapter {

    private FileBasedUserRepo fileBasedUserRepo;

    public AdminUdapter(FileBasedUserRepo fileBasedUserRepo) {
        this.fileBasedUserRepo = fileBasedUserRepo;
    }

    public int seeAdminBalance(String login) {
        int balance = Integer.parseInt(fileBasedUserRepo.getUser(login).getBalance());
        return balance;
    }

    public void removeUser(String login){
        fileBasedUserRepo.removeOldUser(login);
    }

    public void addNewUser(User user){
        fileBasedUserRepo.addNewUser(user);
    }



}
