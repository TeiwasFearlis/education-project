package ru.education.bank.Admin;

import ru.education.bank.IUser;
import ru.education.bank.PersonType;
import ru.education.bank.SimpleUser.SimpleUser;
import ru.education.bank.SimulatorLogFile;

import java.math.BigDecimal;

public class Admin implements IAdmin {

    private final String login;
    private final String password;
    private final AdminOperationAdapter adminOperation;
    private final SimulatorLogFile simulatorLogFile = new SimulatorLogFile();


    public Admin(String login, String password,AdminOperationAdapter adminOperationAdapter) {
        this.login = login;
        this.password = password;
        this.adminOperation = adminOperationAdapter;
    }


    @Override
    public BigDecimal seeBalance(String login) {
        simulatorLogFile.logFile(getLogin(), " try see user`s balance "+login);
        return adminOperation.seeBalance(login);
    }

    @Override
    public void addMoney(String login, BigDecimal number) {
        simulatorLogFile.logFile(getLogin(), " try add "+number+" money user "+login);
        adminOperation.addMoney(login, number);
    }


    @Override
    public void removeUser(String login) {
        simulatorLogFile.logFile(getLogin(), "try remove user "+login);
        adminOperation.removeUser(login);

    }


    @Override
    public void addNewUser(IUser user) {
        simulatorLogFile.logFile(getLogin(), "try add new user");
        adminOperation.addNewUser(user);
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
