package ru.education.bank;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

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
//        repo.addNewUser(new User("test234","pass234"));
//        repo.addNewUser(new User("Hello","word"));
//        repo.addNewUser(new User("sdgdfdf","gfghh"));
//        repo.addNewUser(new User("123434534","56788"));
//        repo.addNewUser(new User("123","56"));
        repo.addNewUser(new User("ss","gg"));
        assertNotNull(repo.getUser("ss"));
        repo = new FileBasedUserRepo();
         assertNotNull(repo.getUser("gg"));
    }

    @Test
    public void test() {
        UserRepo repo = new InMemoryUserRepo();
        User x = new User("user1", "pass1");
        User x2 = new User("user1", "pass1");
        System.out.println(x.equals(x2));
    }

    @Test
    public void dublicateuserTest(){
        File file=null;
        try{
            file = new File("testRepo.txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            UserRepo repo = new FileBasedUserRepo(file);
            User x = new User("user1", "pass1");
            repo.addNewUser(x);// first user
            User x2 = new User("user1", "pass1");
            IllegalStateException exception = assertThrows(IllegalStateException.class, () -> repo.addNewUser(x2));
            assertEquals("User already exist!",exception.getMessage());
        }finally {
            if(file!=null){
                file.delete();
            }
        }
    }
}
