package ru.education.bank;


public class BankSystem {

    private final Authorization auth = new Authorization();

    public boolean check(User user){
       return auth.auth(user.getLogin(),user.getPassword());
    }

}