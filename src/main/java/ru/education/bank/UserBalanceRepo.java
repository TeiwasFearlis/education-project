package ru.education.bank;

import java.util.List;

public interface UserBalanceRepo {

    void removeUserBalance(String login);
    void addUserBalance(User user)throws IllegalStateException;
    String getUserBalance(String login);
    List<User> getUserBalanceList();


}
