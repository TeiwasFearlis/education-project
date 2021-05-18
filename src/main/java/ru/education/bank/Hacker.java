package ru.education.bank;

import ru.education.bank.SimpleUser.SimpleUser;
import ru.education.bank.SimpleUser.UserOperationAdapter;

import java.math.BigDecimal;

public class Hacker extends SimpleUser {


    public Hacker(String login, String password, BigDecimal balance, UserOperationAdapter adapter,int timeToLive) {
        super(login, password, balance, adapter,timeToLive);
    }


    private void hack(String login) {

    }
    private void hack2(String login) {

    }


    void notRealhack(String login){

    }


}
