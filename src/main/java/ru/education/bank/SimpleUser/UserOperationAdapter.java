package ru.education.bank.SimpleUser;

import ru.education.bank.FileBasedUserRepo;
import ru.education.bank.IUser;
import ru.education.bank.SimulatorLogFile;
import ru.education.bank.UserRepo;

import java.math.BigDecimal;
import java.math.RoundingMode;


public final class UserOperationAdapter {
    SimulatorLogFile simulatorLogFile = new SimulatorLogFile();
    private final UserRepo fileBasedUserRepo;

    public UserOperationAdapter(UserRepo fileBasedUserRepo) {
        this.fileBasedUserRepo = fileBasedUserRepo;

    }

    public BigDecimal seeBalance(String login) {
        return fileBasedUserRepo.getUser(login).getBalance().setScale(2, RoundingMode.HALF_UP);
    }


    public BigDecimal takeMoney(String login, BigDecimal number) {
        BigDecimal balance = seeBalance(login);
        BigDecimal newBalance;

            if (balance.compareTo(BigDecimal.valueOf(0)) < 1) {
                simulatorLogFile.logFile(login, "try take his money,but his balance is negative");
                throw new IllegalStateException("Sorry!Your balance is negative");
            } else if (balance.compareTo(number) < 1) {
                simulatorLogFile.logFile(login, "try take his money,but he doesn't have that amount");
                throw new IllegalStateException("Sorry!You don't have an input amount");
            } else if (number.compareTo(BigDecimal.valueOf(0)) >= 0) {
                newBalance = balance.subtract(number);
                IUser oldUser = fileBasedUserRepo.getUser(login);
                SimpleUser user = new SimpleUser(oldUser.getLogin(),
                        oldUser.getPassword(),
                        newBalance,
                        new UserOperationAdapter(fileBasedUserRepo),
                        fileBasedUserRepo.getTimeToLive());
                fileBasedUserRepo.removeOldUser(login);
                fileBasedUserRepo.addNewUser(user);
                return user.getBalance();
            } else {
                simulatorLogFile.logFile(login, "try take his money,but he input negative number");
                throw new IllegalStateException("the number must be positive");
            }
    }

    private BigDecimal sendMoney(String login, BigDecimal number) {
        BigDecimal balance = seeBalance(login);
        BigDecimal newBalance;
        if (number.compareTo(BigDecimal.valueOf(0)) < 0) {
            simulatorLogFile.logFile(login, "try take his money,but his balance is negative");
            throw new IllegalStateException("Sorry!Your number is negative");
        }
        if (number.compareTo(BigDecimal.valueOf(0)) > 0) {
            newBalance = balance.add(number);
            IUser olduser = fileBasedUserRepo.getUser(login);
            SimpleUser user = new SimpleUser(olduser.getLogin(),
                    olduser.getPassword(),
                    newBalance,
                    new UserOperationAdapter(fileBasedUserRepo),
                    fileBasedUserRepo.getTimeToLive());
            fileBasedUserRepo.removeOldUser(login);
            fileBasedUserRepo.addNewUser(user);
            return user.getBalance();
        } else {
            simulatorLogFile.logFile(login, "try give his money,but number is zero");
            throw new IllegalStateException("Sorry!Your number is zero");
        }
    }


    public synchronized BigDecimal sendMoney(String fromLogin, String toLogin, BigDecimal number) {
        takeMoney(fromLogin, number);
        return sendMoney(toLogin, number);
    }
}
