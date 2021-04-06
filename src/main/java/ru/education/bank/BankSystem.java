package ru.education.bank;


public class BankSystem {

    private final Authorization auth = new Authorization(new FileBasedUserRepo());

    private final IUserContainer container = null;

    public boolean check(IUser user){
       return auth.auth(user);
    }


    //TODO таска которая должна с заданным периодом чистить container от просроченных пользователей
    private class ClearTask implements Runnable{

        @Override
        public void run() {

        }
    }

}