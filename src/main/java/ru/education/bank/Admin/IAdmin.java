package ru.education.bank.Admin;

import ru.education.bank.IUser;

import java.math.BigDecimal;

public interface IAdmin extends IUser {

    BigDecimal seeBalance(String login);

    void addMoney(String login, BigDecimal number);

    void removeUser(String login);

    public void addNewUser(IUser user);

}
