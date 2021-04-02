package ru.education.bank;

import org.junit.jupiter.api.Test;
import ru.education.bank.SimpleUser.SimpleUser;
import ru.education.bank.SimpleUser.UserOperationAdapter;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationTest {
    final UserRepo repo= new FileBasedUserRepo();
    final Authorization authorization = new Authorization(repo);
    final BigDecimal balance = new BigDecimal("100");


    @Test
    public void testToFix() {
        assertTrue(authorization.auth(new SimpleUser("Cat", "113",balance, new UserOperationAdapter(repo))));
    }

    @Test
    public void testAuthOK() {
        assertTrue(authorization.auth(new SimpleUser("fifa", "6", balance, new UserOperationAdapter(repo))));
    }

    @Test
    public void testAuthFail() {
        assertFalse(authorization.auth(new SimpleUser("Cat", "null", balance, new UserOperationAdapter(repo))));
    }

    @Test
    public void testAuthFail2() {
        assertFalse(authorization.auth(new SimpleUser("null", "113", balance, new UserOperationAdapter(repo))));
    }


    @Test
    public void testAuthFail3() {
        assertFalse(authorization.auth(new SimpleUser("", "113", balance, new UserOperationAdapter(repo))));
    }


    @Test
    public void loadTest() {
        long start = System.currentTimeMillis();//10
        authorization.auth(new SimpleUser("Cat", "113",balance, new UserOperationAdapter(repo)));//X
        System.out.println("Time executed:" + (System.currentTimeMillis()/*30*/ - start/*10*/));
    }


    @Test
    public void testToFix2() {
        SimpleUser SimpleUser = new SimpleUser("Cat", "113",balance, new UserOperationAdapter(repo));
        assertTrue(authorization.auth(SimpleUser));
        Hacker hacker = new Hacker("Cat", "113",balance,new UserOperationAdapter(repo));
        assertFalse(authorization.auth(hacker));
    }

}