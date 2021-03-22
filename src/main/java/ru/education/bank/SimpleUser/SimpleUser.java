package ru.education.bank.SimpleUser;

import ru.education.bank.FileBasedUserRepo;
import ru.education.bank.PersonType;
import ru.education.bank.User;

public class SimpleUser implements ISimpleUser {

    SimpleUserUdapter simpleUserUdapter = new SimpleUserUdapter(new FileBasedUserRepo());

    private User user;

    public SimpleUser(User user) {
        this.user = user;
    }

    @Override
    public int seeBalance() {
      return simpleUserUdapter.seeUserBalance(getLogin());
    }

    @Override
    public int takeMoney(int number) {
        int balance = seeBalance();
        if (balance >= number && number >= 0) {
            int result = balance - number;
            return result;
        } else {
            throw new IllegalArgumentException("the number must be positive");
        }
    }

    @Override
    public int sendMoney(String login, int number) {
       int opponentBalance =  simpleUserUdapter.seeUserBalance(login);
       int myBalance = seeBalance();
        if (myBalance >= number && number >= 0) {
            int resultUserBalance = myBalance - number;
            //добавить метод перезаписи баланса
            int resultOpponentBalance = opponentBalance + number;
            //добавить метод перезаписи баланса оппонента
            return resultOpponentBalance;
        } else {
            throw new IllegalArgumentException("the number must be positive");
        }
    }

    @Override
    public String getLogin() {
        return user.getLogin();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getBalance() {
        return user.getBalance();
    }


    @Override
    public PersonType getPerson() {
        return PersonType.SIMPLE_USER;
    }
}
