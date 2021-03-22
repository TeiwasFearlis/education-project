package ru.education.bank.Admin;

import ru.education.bank.IUser;
import ru.education.bank.User;

public interface IAdmin extends IUser {
    int seeBalance(String login);

    int addMoney(String login, int number);

    void removeUser(String login);


    public void addNewUser(User user);

}
