package ru.education.bank.SimpleUser;

import ru.education.bank.IUser;

public interface ISimpleUser extends IUser {
    int seeBalance();

    int takeMoney(int number);

    int sendMoney(String login,int number);
}
