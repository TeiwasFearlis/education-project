package ru.education.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationTest {

   final Authorization authorization =new Authorization();

    @Test
    public void testToFix(){
        assertTrue(authorization.auth("VanDam","derPorol"));
    }

    @Test
    public void testAuthOK(){
        assertTrue(authorization.auth("fix","fix"));
    }

    @Test
    public void testAuthFail(){
        assertFalse(authorization.auth("TEST","TEST"));
    }

    @Test
    public void testAuthFail2(){
        assertFalse(authorization.auth("Dracula","TEST"));
    }


    @Test
    public void loadTest(){
        long start  = System.currentTimeMillis();//10
        authorization.auth("agh","ad");//X
        System.out.println("Time executed:"+(System.currentTimeMillis()/*30*/-start/*10*/));
    }
}