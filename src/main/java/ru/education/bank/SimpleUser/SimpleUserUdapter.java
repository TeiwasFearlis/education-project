package ru.education.bank.SimpleUser;

import ru.education.bank.FileBasedUserRepo;
import ru.education.bank.User;


public class SimpleUserUdapter  {
    private FileBasedUserRepo fileBasedUserRepo;

    public SimpleUserUdapter(FileBasedUserRepo fileBasedUserRepo) {
        this.fileBasedUserRepo = fileBasedUserRepo;
    }

    public int seeUserBalance(String login) {
        int balance = Integer.parseInt(fileBasedUserRepo.getUser(login).getBalance());
        return balance;
    }


}
