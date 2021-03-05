package ru.education.bank;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepoTest {


    @Test
    public void inMemTest(){
        UserRepo repo = new InMemoryUserRepo();
        repo.addNewUser(new User("test123","pass123"));
        assertNotNull(repo.getUser("test123"));
        repo = new InMemoryUserRepo();
        assertNull(repo.getUser("test123"));
    }

    @Test
    public void inFileTest(){
        UserRepo repo = new FileBasedUserRepo();
        repo.addNewUser(new User("test234","pass234"));
        repo.addNewUser(new User("Hello","word"));
        repo.addNewUser(new User("sdgdfdf","gfghh"));
        repo.addNewUser(new User("123434534","56788"));
        assertNotNull(repo.getUser("test123"));
       // repo = new FileBasedUserRepo();
       // assertNotNull(repo.getUser("test123"));
    }

    @Test
    public void test() {
        UserRepo repo = new InMemoryUserRepo();
        User x = new User("user1", "pass1");
        User x2 = new User("user1", "pass1");
        System.out.println(x.equals(x2));
    }
}
