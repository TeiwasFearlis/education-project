package ru.education.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationTest {

   final Authorization authorization =new Authorization();

    @Test
    public void testAuthOK(){
        assertTrue(authorization.auth("Dracula","123"));
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
    public void testEqualsLoginPassword(){
        assertTrue(authorization.equalsLoginPassword("Dracula","123"));
    }

    @Test
    public void testEqualsLoginPassword2(){
        assertFalse(authorization.equalsLoginPassword("Dracul","12"));
    }

    @Test
    public void testEqualsLoginPassword3(){
        assertFalse(authorization.equalsLoginPassword("123","Dracula"));
    }
    @Test
    public void testEqualsLoginPassword4(){
        assertFalse(authorization.equalsLoginPassword("test","test"));
    }


}