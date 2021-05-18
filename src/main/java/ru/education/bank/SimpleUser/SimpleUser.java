package ru.education.bank.SimpleUser;

import ru.education.bank.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimpleUser extends DeadableUser implements ISimpleUser {


    private final String login;
    private final String password;
    private BigDecimal balance;
    private final UserOperationAdapter userOperation;
    private final Date date;
    private volatile boolean valid = true;

    public SimpleUser(String login, String password, BigDecimal balance, UserOperationAdapter userOperation, int timeToLive) {
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.userOperation = userOperation;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, timeToLive);
        this.date = calendar.getTime();
        System.out.println(date);
    }


    SimulatorLogFile simulatorLogFile = new SimulatorLogFile();


    @Override
    public BigDecimal seeBalance() {
        super.check();
        simulatorLogFile.logFile(getLogin(), "try see his balance");
        return userOperation.seeBalance(getLogin());
    }

    @Override
    public void takeMoney(BigDecimal number) {
        super.check();
        simulatorLogFile.logFile(getLogin(), "try take his money:" + number);
        this.balance = userOperation.takeMoney(getLogin(), number);
    }

    @Override
    public void sendMoney(String login, BigDecimal number) {
        if (isValid()) {
            this.balance = userOperation.sendMoney(getLogin(), login, number);
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
        return balance;
    }


    @Override
    public PersonType getPerson() {
        return PersonType.SIMPLE_USER;
    }


}
