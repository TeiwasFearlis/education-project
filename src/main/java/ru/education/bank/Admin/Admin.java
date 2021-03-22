package ru.education.bank.Admin;

import ru.education.bank.FileBasedUserRepo;
import ru.education.bank.PersonType;
import ru.education.bank.User;

public class Admin implements IAdmin {
    AdminUdapter adminUdapter = new AdminUdapter(new FileBasedUserRepo());
    private User user;

    public Admin(User user) {
        this.user = user;
    }

    @Override
    public int seeBalance(String login) {
        return adminUdapter.seeAdminBalance(login);
    }

    @Override
    public int addMoney(String login, int number) {

        int balance = seeBalance(login);
        if (balance >= number && number >= 0) {
            int result = balance + number;
            return result;
        } else {
            throw new IllegalArgumentException("the number must be positive");
        }
    }


    @Override
    public void removeUser(String login) {
        adminUdapter.removeUser(login);

    }

    @Override
    public void addNewUser(User user) {
        adminUdapter.addNewUser(user);
    }

    @Override
    public String getLogin() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getBalance() {
        return null;
    }

    @Override
    public PersonType getPerson() {
        return PersonType.ADMIN;
    }


}
