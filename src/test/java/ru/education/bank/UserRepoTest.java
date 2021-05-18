package ru.education.bank;

import org.junit.jupiter.api.Test;
import ru.education.bank.SimpleUser.SimpleUser;
import ru.education.bank.SimpleUser.UserOperationAdapter;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepoTest {
    final BigDecimal balance = new BigDecimal("100");
    private int timeToLive =5;


    @Test
    public void inFileTest() throws IOException, IllegalAccessException {
        UserRepo repo = new FileBasedUserRepo(copyFromFile(new File("loginPassword")), timeToLive);
        // UserRepo repo = new FileBasedUserRepo(new File("loginPassword"));
//        repo.addNewUser(new User("test234","pass234","100" ));
//        repo.addNewUser(new User("Hello","word","500000" ));
//        repo.addNewUser(new User("sdgdfdf","gfghh","750000" ));
//        repo.addNewUser(new User("123434534","56788", "20000"));
//        repo.addNewUser(new User("123","56", "1000"));
//        repo.addNewUser(new User("ss","gg", "11000"));
        repo.addNewUser(new SimpleUser("pod", "gg",  new BigDecimal("100"),  new UserOperationAdapter(repo),timeToLive));
        assertNotNull(repo.getUser("pod"));
        repo = new FileBasedUserRepo(timeToLive);
        assertNotNull(repo.getUser("pod"));
    }

    private File copyFromFile(File original) throws IOException, IllegalAccessException {
        File newFile = new File("copy_" + original.getName());
        if (newFile.createNewFile()) {
            Files.write(newFile.toPath(), Files.readAllBytes(original.toPath()));
            return newFile;
        } else {
            throw new IllegalAccessException("Cant copy file:" + original.getName());
        }
    }

    @Test
    public void dublicateuserTest() {
        File file = null;
        try {
            file = new File("testRepo.txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            UserRepo repo = new FileBasedUserRepo(file, timeToLive);
            SimpleUser x = new SimpleUser("user1", "pass1", balance, new UserOperationAdapter(repo),timeToLive);
            repo.addNewUser(x);// first user
            SimpleUser x2 = new SimpleUser("user1", "pass1", balance, new UserOperationAdapter(repo),timeToLive);
            IllegalStateException exception = assertThrows(IllegalStateException.class, () -> repo.addNewUser(x2));
            assertEquals("User already exist!", exception.getMessage());
        } finally {
            if (file != null) {
                file.delete();
            }
        }
    }


    @Test
    public void removeUser() throws IOException, IllegalAccessException {
        File loginPassword2 = null;
        try {
            loginPassword2 = copyFromFile(new File("loginPassword"));
            FileBasedUserRepo ff = new FileBasedUserRepo(loginPassword2, timeToLive);
            ff.removeOldUser("Hello");
            assertNull(ff.getUser("Hello"));
        } finally {
            if (loginPassword2 != null) {
                loginPassword2.delete();
            }
        }
    }
}
