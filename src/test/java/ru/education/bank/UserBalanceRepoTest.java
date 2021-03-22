package ru.education.bank;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class UserBalanceRepoTest {






    @Test
    public void inFileBalanceTest() throws IOException, IllegalAccessException {
        UserBalanceRepo repo = new FileUserBalance(copyFromFileBalance(new File("userBalance")));
       // UserBalanceRepo repo = new FileUserBalance();
//        repo.addUserBalance(new User("test234",100000));
//        repo.addUserBalance(new User("sdgdfdf",50000));
//        repo.addUserBalance(new User("123434534",300000));
//        repo.addUserBalance(new User("ss",1000));
//        repo.addUserBalance(new User("Hello",700000));
//        repo.addUserBalance(new User("123",200));
       // repo.addUserBalance(new User("125",200));

        assertNotNull(repo.getUserBalance("ss"));
        repo = new FileUserBalance();
         assertNotNull(repo.getUserBalance("ss"));
    }


    @Test
    public void removeUserBalance() throws IOException, IllegalAccessException {
        File userBalance2 = null;
        try {
            userBalance2 = copyFromFileBalance(new File("userBalance"));
            FileUserBalance ff = new FileUserBalance(userBalance2);
            ff.removeUserBalance("Hello");
            assertNull(ff.getUserBalance("Hello"));
        }finally {
            if(userBalance2 !=null){
                userBalance2.delete();
            }
        }
    }

    private File copyFromFileBalance(File original) throws IOException, IllegalAccessException {
        File newFile = new File("copy_"+original.getName());
        if(newFile.createNewFile()){
            Files.write(newFile.toPath(), Files.readAllBytes(original.toPath()));
            return newFile;
        }else {
            throw new IllegalAccessException("Cant copy file:"+original.getName());
        }
    }

    @Test
    public void dublicateuserBalanceTest(){
        File file=null;
        try{
            file = new File("testBalanceRepo.txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            UserBalanceRepo repo = new FileUserBalance(file);
            User x = new User("user1", "123","100");
            repo.addUserBalance(x);// first user
            User x2 = new User("user1", "123","100");
            IllegalStateException exception = assertThrows(IllegalStateException.class, () -> repo.addUserBalance(x2));
            assertEquals("User already exist!",exception.getMessage());
        }finally {
            if(file!=null){
                file.delete();
            }
        }
    }
}
