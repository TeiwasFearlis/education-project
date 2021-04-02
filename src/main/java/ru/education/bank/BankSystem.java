package ru.education.bank;


public class BankSystem {

    private final Authorization auth = new Authorization(new FileBasedUserRepo());

    public boolean check(IUser user){
       return auth.auth(user);
    }


}