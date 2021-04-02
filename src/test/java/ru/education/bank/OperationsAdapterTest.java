package ru.education.bank;

import org.junit.jupiter.api.Test;
import ru.education.bank.SimpleUser.SimpleUser;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.*;

public class OperationsAdapterTest {

    @Test
    public void goodSendMoneyTest() throws IOException, IllegalAccessException {
        File loginPassword2 = null;
        try {
            loginPassword2 = copyFromFile(new File("loginPassword"));
            FileBasedUserRepo ff = new FileBasedUserRepo(loginPassword2);
            SimpleUser sender = (SimpleUser) ff.getUser("Hello");
            assertNotNull(sender);
            String receiverLogin = "123";

            BigDecimal oldBalance =  sender.getBalance();
            BigDecimal number = BigDecimal.valueOf(1000L).setScale(2, RoundingMode.HALF_UP);
            BigDecimal receiverBalance = new BigDecimal(2000L).setScale(2, RoundingMode.HALF_UP);

            sender.sendMoney(receiverLogin, number);

            BigDecimal newBalance = sender.getBalance();

            SimpleUser receiver = (SimpleUser) ff.getUser(receiverLogin);
            assertNotNull(receiver);
            assertTrue(newBalance.compareTo(oldBalance) !=0);
            assertEquals(receiver.getBalance().compareTo(receiverBalance), 0);
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
            SimpleUser sender = (SimpleUser) ff.getUser("Hello");
            assertNotNull(sender);
            String receiverLogin = "123";

            BigDecimal oldBalance =  sender.getBalance();
            BigDecimal number = BigDecimal.valueOf(-1000L).setScale(2, RoundingMode.HALF_UP);
            BigDecimal receiverBalance = new BigDecimal(2000L).setScale(2, RoundingMode.HALF_UP);
            IllegalStateException exception = assertThrows(IllegalStateException.class, () ->  sender.sendMoney(receiverLogin, number));
            assertEquals("the number must be positive", exception.getMessage());
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
            SimpleUser sender = (SimpleUser) ff.getUser("Hello");
            assertNotNull(sender);
            String receiverLogin = "123";

            BigDecimal oldBalance =  sender.getBalance();
            BigDecimal number = BigDecimal.valueOf(1000000L).setScale(2, RoundingMode.HALF_UP);
            BigDecimal receiverBalance = new BigDecimal(2000L).setScale(2, RoundingMode.HALF_UP);
            IllegalStateException exception = assertThrows(IllegalStateException.class, () ->  sender.sendMoney(receiverLogin, number));
            assertEquals("Sorry!You don't have an input amount", exception.getMessage());
        }finally {
            if(loginPassword2!=null){
                loginPassword2.delete();
            }
        }
    }

    @Test
    public void badSendMoneyTest3() throws IOException, IllegalAccessException {
        File loginPassword2 = null;
        try {
            loginPassword2 = copyFromFile(new File("loginPassword"));
            FileBasedUserRepo ff = new FileBasedUserRepo(loginPassword2);
            SimpleUser sender = (SimpleUser) ff.getUser("pod");
            assertNotNull(sender);
            String receiverLogin = "123";

            BigDecimal oldBalance =  sender.getBalance();
            BigDecimal number = BigDecimal.valueOf(1000L).setScale(2, RoundingMode.HALF_UP);
            BigDecimal receiverBalance = new BigDecimal(2000L).setScale(2, RoundingMode.HALF_UP);
            IllegalStateException exception = assertThrows(IllegalStateException.class, () ->  sender.sendMoney(receiverLogin, number));
            assertEquals("Sorry!Your balance is negative", exception.getMessage());
        }finally {
            if(loginPassword2!=null){
                loginPassword2.delete();
            }
        }
    }


    @Test
    public void badSendMoneyTest4() throws IOException, IllegalAccessException {
        File loginPassword2 = null;
        try {
            loginPassword2 = copyFromFile(new File("loginPassword"));
            FileBasedUserRepo ff = new FileBasedUserRepo(loginPassword2);
            SimpleUser sender = (SimpleUser) ff.getUser("Hello");
            assertNotNull(sender);
            String receiverLogin = "123";

            BigDecimal oldBalance =  sender.getBalance();
            BigDecimal number = BigDecimal.valueOf(0L).setScale(2, RoundingMode.HALF_UP);
            BigDecimal receiverBalance = new BigDecimal(2000L).setScale(2, RoundingMode.HALF_UP);
            IllegalStateException exception = assertThrows(IllegalStateException.class, () ->  sender.sendMoney(receiverLogin, number));
            assertEquals("Sorry!Your number is zero", exception.getMessage());
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
