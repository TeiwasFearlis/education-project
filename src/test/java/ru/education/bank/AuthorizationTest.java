package ru.education.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationTest {

    final Authorization authorization = new Authorization(new InMemoryUserRepo());


    @Test
    public void testToFix() {
        assertTrue(authorization.auth(new User("Cat", "113","100" )));
    }

    @Test
    public void testAuthOK() {
        assertTrue(authorization.auth(new User("fifa", "6", "100")));
    }

    @Test
    public void testAuthFail() {
        assertFalse(authorization.auth(new User("Cat", "null", "100")));
    }

    @Test
    public void testAuthFail2() {
        assertFalse(authorization.auth(new User("null", "113", "100")));
    }


    @Test
    public void testAuthFail3() {
        assertFalse(authorization.auth(new User("", "113", "100")));
    }


    @Test
    public void loadTest() {
        long start = System.currentTimeMillis();//10
        authorization.auth(new User("Cat", "113","100" ));//X
        System.out.println("Time executed:" + (System.currentTimeMillis()/*30*/ - start/*10*/));
    }


    @Test
    public void testToFix2() {
        User user = new User("Cat", "113","100" );
        assertTrue(authorization.auth(user));
        Hacker hacker = new Hacker("Cat", "113","100");
        assertFalse(authorization.auth(hacker));
    }

}