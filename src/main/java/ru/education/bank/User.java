package ru.education.bank;

public class User {
    private final String login;
    private final String password;

    public User(String login, String passsword) {
        this.login = login;
        this.password = passsword;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }



}
