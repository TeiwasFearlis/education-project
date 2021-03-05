package ru.education.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationTest {

   final Authorization authorization =new Authorization(new InMemoryUserRepo());

    @Test
    public void testToFix(){
        assertTrue(authorization.auth("Cat","113"));
    }

    @Test
    public void testAuthOK(){
        assertTrue(authorization.auth("fifa","6"));
    }

    @Test
    public void testAuthFail(){
        assertFalse(authorization.auth("Cat","null"));
    }

    @Test
    public void testAuthFail2(){
        assertFalse(authorization.auth("null","113"));
    }


    @Test
    public void testAuthFail3(){
        assertFalse(authorization.auth("","113"));
    }


    @Test
    public void loadTest(){
        long start  = System.currentTimeMillis();//10
        authorization.auth("Cat","113");//X
        System.out.println("Time executed:"+(System.currentTimeMillis()/*30*/-start/*10*/));
    }
}