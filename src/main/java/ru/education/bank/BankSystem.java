package ru.education.bank;


import ru.education.bank.SimpleUser.SimpleUser;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BankSystem implements AutoCloseable  {

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public BankSystem(){
        executor.schedule(new ClearTask(),10, TimeUnit.SECONDS);
    }

    final private static int timeToLiveSeconds = 5;

    private final Authorization auth = new Authorization(new FileBasedUserRepo(timeToLiveSeconds));

    private final IUserContainer container = new UserContainer();

    public IUser check(String login, String password){
        IUser user = this.auth.auth(login, password);
        if(user!=null){
            container.put(user.getLogin(),user);
        }
        return user;
    }

    public List<IUser> getValidUsers(){
      return container.getValidUsers();
    }

    @Override
    public void close() {
        executor.shutdown();
    }



    private class ClearTask implements Runnable{

        @Override
        public void run() {
                container.clearInvalidUsers();
        }
    }

}