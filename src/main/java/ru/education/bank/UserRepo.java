package ru.education.bank;

import java.util.List;

public interface UserRepo {
    void addNewUser(IUser user) throws IllegalStateException;
    IUser getUser(String login);
    List<IUser> getUserList();
    void removeOldUser(String login);
}
