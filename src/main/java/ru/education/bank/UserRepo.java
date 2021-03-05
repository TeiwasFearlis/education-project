package ru.education.bank;

import java.io.IOException;
import java.util.List;

public interface UserRepo {
    void addNewUser(User user);
    User getUser(String login);
    List<User> getUserList();
}
