package ru.education.bank;


public class BankSystem {

    private final Authorization auth = new Authorization(new FileBasedUserRepo());
//    private final Authorization auth = new Authorization(new InMemoryUserRepo());

    public boolean check(User user){
       return auth.auth(user);
    }


}