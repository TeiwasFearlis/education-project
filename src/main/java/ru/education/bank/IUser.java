package ru.education.bank;

import java.math.BigDecimal;

public interface IUser {

    String getLogin();

    String getPassword();

    BigDecimal getBalance();

    PersonType getPerson();

    boolean isValid();

}
