package ru.education.bank.SimpleUser;

import ru.education.bank.IUser;

import java.math.BigDecimal;

public interface ISimpleUser extends IUser {
    BigDecimal seeBalance();

    void takeMoney(BigDecimal number);

    void sendMoney(String login, BigDecimal number);
}
