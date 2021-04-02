package ru.education.bank;

import org.junit.jupiter.api.Test;
import ru.education.bank.Admin.Admin;
import ru.education.bank.Admin.AdminOperationAdapter;
import ru.education.bank.SimpleUser.SimpleUser;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {

    @Test
    public void goodSendMoneyTest() throws IOException, IllegalAccessException {
        File loginPassword2 = null;
        try {
            loginPassword2 = copyFromFile(new File("loginPassword"));
            FileBasedUserRepo ff = new FileBasedUserRepo(loginPassword2);
            Admin admin = (Admin) ff.getUser("ss");
            assertNotNull(admin);
            SimpleUser simpleUser = (SimpleUser) ff.getUser("123");
            assertNotNull(simpleUser);
            BigDecimal oldBalance =  simpleUser.getBalance();
            BigDecimal number = BigDecimal.valueOf(1000L).setScale(2, RoundingMode.HALF_UP);
            BigDecimal receiverBalance = new BigDecimal(2000L).setScale(2, RoundingMode.HALF_UP);
            admin.addMoney(simpleUser.getLogin(), number);
            SimpleUser newSimpleUser = (SimpleUser) ff.getUser("123");
            BigDecimal newBalance = newSimpleUser.getBalance();//TODO правильно ли сделан тест?
            assertTrue(newBalance.compareTo(oldBalance) !=0);
            assertEquals(newSimpleUser.getBalance().compareTo(receiverBalance), 0);
        }finally {
            if(loginPassword2!=null){
                loginPassword2.delete();
            }
        }
    }



    @Test
    public void badSendMoneyTest() throws IOException, IllegalAccessException {
        File loginPassword2 = null;
        try {
            loginPassword2 = copyFromFile(new File("loginPassword"));
            FileBasedUserRepo ff = new FileBasedUserRepo(loginPassword2);
            Admin admin = (Admin) ff.getUser("ss");
            assertNotNull(admin);
            SimpleUser simpleUser = (SimpleUser) ff.getUser("123");
            assertNotNull(simpleUser);
            BigDecimal number = BigDecimal.valueOf(-1000L).setScale(2, RoundingMode.HALF_UP);
            IllegalStateException exception = assertThrows(IllegalStateException.class, () ->  admin.addMoney(simpleUser.getLogin(), number));
            assertEquals("Sorry!Your number is negative", exception.getMessage());
        }finally {
            if(loginPassword2!=null){
                loginPassword2.delete();
            }
        }
    }


    @Test
    public void badSendMoneyTest2() throws IOException, IllegalAccessException {
        File loginPassword2 = null;
        try {
            loginPassword2 = copyFromFile(new File("loginPassword"));
            FileBasedUserRepo ff = new FileBasedUserRepo(loginPassword2);
            Admin admin = (Admin) ff.getUser("ss");
            assertNotNull(admin);
            SimpleUser simpleUser = (SimpleUser) ff.getUser("123");
            assertNotNull(simpleUser);
            BigDecimal number = BigDecimal.valueOf(0L).setScale(2, RoundingMode.HALF_UP);
            IllegalStateException exception = assertThrows(IllegalStateException.class, () ->  admin.addMoney(simpleUser.getLogin(), number));
            assertEquals("Sorry!Your number is zero", exception.getMessage());
        }finally {
            if(loginPassword2!=null){
                loginPassword2.delete();
            }
        }
    }

    @Test
    public void addNewUserTest() throws IOException, IllegalAccessException {
        File loginPassword2 = null;
        try {
            loginPassword2 = copyFromFile(new File("loginPassword"));
            FileBasedUserRepo ff = new FileBasedUserRepo(loginPassword2);
            Admin admin = (Admin) ff.getUser("ss");
            assertNotNull(admin);
            IllegalStateException exception = assertThrows(IllegalStateException.class, () -> admin.addNewUser(new Admin("ss","gg", new AdminOperationAdapter(new FileBasedUserRepo()))));
            assertEquals("User already exist!", exception.getMessage());
        }finally {
            if(loginPassword2!=null){
                loginPassword2.delete();
            }
        }
    }

    @Test
    public void addNewUserTest2() throws IOException, IllegalAccessException {
        File loginPassword2 = null;
        try {
            loginPassword2 = copyFromFile(new File("loginPassword"));
            FileBasedUserRepo ff = new FileBasedUserRepo(loginPassword2);
            Admin admin = (Admin) ff.getUser("ss");
            assertNotNull(admin);
            admin.addNewUser(new Admin("1234","4321", new AdminOperationAdapter(new FileBasedUserRepo())));
            Admin admi2 = (Admin) ff.getUser("1234");
            assertNotNull(admi2);
        }finally {
            if(loginPassword2!=null){
                loginPassword2.delete();
            }
        }
    }

    @Test
    public void removeUserTest() throws IOException, IllegalAccessException {
        File loginPassword2 = null;
        try {
            loginPassword2 = copyFromFile(new File("loginPassword"));
            FileBasedUserRepo ff = new FileBasedUserRepo(loginPassword2);
            Admin admin = (Admin) ff.getUser("ss");
            assertNotNull(admin);
            admin.addNewUser(new Admin("1234","4321", new AdminOperationAdapter(new FileBasedUserRepo())));
            Admin admin2 = (Admin) ff.getUser("1234");
            assertNotNull(admin2);
            admin.removeUser(admin2.getLogin());
            Admin admin3 = (Admin) ff.getUser("1234");
            assertNull(admin3);
        }finally {
            if(loginPassword2!=null){
                loginPassword2.delete();
            }
        }
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
}
