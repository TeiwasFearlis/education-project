package ru.education.bank.SimpleUser;

import ru.education.bank.*;

import java.math.BigDecimal;

public class SimpleUser implements ISimpleUser {

    private final String login;
    private final String password;
    private BigDecimal balance;
    private final UserOperationAdapter userOperation;


    public SimpleUser(String login, String password, BigDecimal balance, UserOperationAdapter userOperation) {
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.userOperation = userOperation;
    }

    SimulatorLogFile simulatorLogFile = new SimulatorLogFile();


    @Override
    public BigDecimal seeBalance() {
        simulatorLogFile.logFile(getLogin(), "try see his balance");
        return userOperation.seeBalance(getLogin());
    }

    @Override
    public void takeMoney(BigDecimal number) {
        simulatorLogFile.logFile(getLogin(), "try take his money:"+number);
        this.balance = userOperation.takeMoney(getLogin(), number);
    }

    @Override
    public void sendMoney(String login, BigDecimal number) {
        this.balance = userOperation.sendMoney(getLogin(),login,number);
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
