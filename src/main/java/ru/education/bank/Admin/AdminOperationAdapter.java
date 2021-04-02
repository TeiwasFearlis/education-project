package ru.education.bank.Admin;

import ru.education.bank.FileBasedUserRepo;
import ru.education.bank.IUser;
import ru.education.bank.SimpleUser.SimpleUser;
import ru.education.bank.SimpleUser.UserOperationAdapter;
import ru.education.bank.SimulatorLogFile;
import ru.education.bank.UserRepo;

import java.math.BigDecimal;

public final class AdminOperationAdapter {
    SimulatorLogFile simulatorLogFile = new SimulatorLogFile();

    private final UserRepo fileBasedUserRepo;

    public AdminOperationAdapter(UserRepo fileBasedUserRepo) {
        this.fileBasedUserRepo = fileBasedUserRepo;
    }


    public void removeUser(String login) {
        fileBasedUserRepo.removeOldUser(login);
    }

    public void addNewUser(IUser user) {
        fileBasedUserRepo.addNewUser(user);
    }

    public BigDecimal addMoney(String login, BigDecimal number) {
        BigDecimal balance = fileBasedUserRepo.getUser(login).getBalance();
        BigDecimal newBalance;
        if (number.compareTo(BigDecimal.valueOf(0)) < 0) {
            simulatorLogFile.logFile(login, "try take his money,but his balance is negative");
            throw new IllegalStateException("Sorry!Your number is negative");
        }
        if (number.compareTo(BigDecimal.valueOf(0)) > 0) {
            newBalance = balance.add(number);
            IUser oldUser = fileBasedUserRepo.getUser(login);
            SimpleUser user = new SimpleUser(oldUser.getLogin(),
                    oldUser.getPassword(),
                    newBalance, new UserOperationAdapter(fileBasedUserRepo));
            fileBasedUserRepo.removeOldUser(login);
            fileBasedUserRepo.addNewUser(user);
            return user.getBalance();
        } else {
            simulatorLogFile.logFile(login, "try take his money,but he input zero");
            throw new IllegalStateException("Sorry!Your number is zero");
        }
    }


    public BigDecimal seeBalance(String login) {
        return fileBasedUserRepo.getUser(login).getBalance();
    }
}