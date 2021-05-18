package ru.education.bank;

import org.junit.jupiter.api.Test;
import ru.education.bank.SimpleUser.SimpleUser;
import ru.education.bank.SimpleUser.UserOperationAdapter;

import java.math.BigDecimal;

class AuthorizationTest {
    private int timeToLive = 5;
    final UserRepo repo = new FileBasedUserRepo(timeToLive);
    final Authorization authorization = new Authorization(repo);
    final BigDecimal balance = new BigDecimal("100");
    private Object Runnable;


    @Test
    public void testToFix() {
        SimpleUser simpleUser = new SimpleUser("Cat", "113", balance, new UserOperationAdapter(repo),timeToLive);

    }


}