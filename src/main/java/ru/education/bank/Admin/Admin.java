package ru.education.bank.Admin;

import ru.education.bank.DeadableUser;
import ru.education.bank.IUser;
import ru.education.bank.PersonType;
import ru.education.bank.SimulatorLogFile;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Admin  extends DeadableUser implements IAdmin {

    private final String login;
    private final String password;
    private final AdminOperationAdapter adminOperation;
    private final SimulatorLogFile simulatorLogFile = new SimulatorLogFile();
    private final Date date ;
    private boolean valid=true;


    public Admin(String login, String password,AdminOperationAdapter adminOperationAdapter,int timeToLive) {
        this.login = login;
        this.password = password;
        this.adminOperation = adminOperationAdapter;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,timeToLive);
        this.date = calendar.getTime();

    }


    @Override
    public BigDecimal seeBalance(String login) {
        if (isValid()) {
            simulatorLogFile.logFile(getLogin(), " try see user`s balance "+login);
            return adminOperation.seeBalance(login);
        } else {
            throw new IllegalStateException("User:" + this.getLogin() + " is invalid");
        }

    }

    @Override
    public void addMoney(String login, BigDecimal number) {
        if (isValid()) {
            simulatorLogFile.logFile(getLogin(), " try add "+number+" money user "+login);
            adminOperation.addMoney(login, number);
        } else {
            throw new IllegalStateException("User:" + this.getLogin() + " is invalid");
        }

    }


    @Override
    public void removeUser(String login) {
        if (isValid()) {
            simulatorLogFile.logFile(getLogin(), "try remove user "+login);
            adminOperation.removeUser(login);
        } else {
            throw new IllegalStateException("User:" + this.getLogin() + " is invalid");
        }


    }


    @Override
    public void addNewUser(IUser user) {
        if (isValid()) {
            simulatorLogFile.logFile(getLogin(), "try add new user");
            adminOperation.addNewUser(user);
        } else {
            throw new IllegalStateException("User:" + this.getLogin() + " is invalid");
        }
    }


    @Override
    public boolean isValid() {
        this.valid = System.currentTimeMillis() < date.getTime();
        return valid;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public BigDecimal getBalance() {
        throw new AbstractMethodError();
    }

    @Override
    public PersonType getPerson() {
        return PersonType.ADMIN;
    }

}
