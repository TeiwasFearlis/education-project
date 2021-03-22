package ru.education.bank;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepoTest {





    @Test
    public void inFileTest() throws IOException, IllegalAccessException {
        UserRepo repo = new FileBasedUserRepo(copyFromFile(new File("loginPassword")));
        // UserRepo repo = new FileBasedUserRepo(new File("loginPassword"));
//        repo.addNewUser(new User("test234","pass234","100" ));
//        repo.addNewUser(new User("Hello","word","500000" ));
//        repo.addNewUser(new User("sdgdfdf","gfghh","750000" ));
//        repo.addNewUser(new User("123434534","56788", "20000"));
//        repo.addNewUser(new User("123","56", "1000"));
//        repo.addNewUser(new User("ss","gg", "11000"));
        assertNotNull(repo.getUser("ss"));
        repo = new FileBasedUserRepo();
        assertNotNull(repo.getUser("ss"));
        System.out.println(repo.getUser("test234"));
    }


    private File copyFromFile(File original) throws IOException, IllegalAccessException {
        File newFile = new File("copy_"+original.getName());
        if(newFile.createNewFile()){
            Files.write(newFile.toPath(), Files.readAllBytes(original.toPath()));
            return newFile;
        }else {
            throw new IllegalAccessException("Cant copy file:"+original.getName());
        }
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
            User x = new User("user1", "pass1","100" );
            repo.addNewUser(x);// first user
            User x2 = new User("user1", "pass1","100" );
            IllegalStateException exception = assertThrows(IllegalStateException.class, () -> repo.addNewUser(x2));
            assertEquals("User already exist!",exception.getMessage());
        }finally {
            if(file!=null){
                file.delete();
            }
        }
    }




    @Test
    public void removeUser() throws IOException, IllegalAccessException {
        File loginPassword2 = null;
        try {
            loginPassword2 = copyFromFile(new File("loginPassword"));
            FileBasedUserRepo ff = new FileBasedUserRepo(loginPassword2);
            ff.removeOldUser("Hello");
            assertNull(ff.getUser("Hello"));
        }finally {
            if(loginPassword2!=null){
                loginPassword2.delete();
            }
        }
    }
    //    @Test
//    public void test() {
//        UserRepo repo = new InMemoryUserRepo();
//        User x = new User("user1", "pass1", );
//        User x2 = new User("user1", "pass1", );

//        System.out.println(x.equals(x2));
//    }
    //    @Test
//    public void inMemTest(){
//        UserRepo repo = new InMemoryUserRepo();
//        repo.addNewUser(new User("test123","pass123", ));
//        assertNotNull(repo.getUser("test123"));
//        repo = new InMemoryUserRepo();
//        assertNull(repo.getUser("test123"));
//    }
}
