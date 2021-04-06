package ru.education.bank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//TODO реализовать его как коллекцию c расширенными методами, засунуть в BankSystem и пользовать его там
// getValidUsers() должен возвращать список текущих залогиненых пользователей
// put() очевидно что бы их хранить нужен метод который позволит их складывать в коллекцию
// clearInvalidUsers метод который будет удалять пользователей с просроченными ТОКЕНАМИ
public abstract class IUserContainer extends HashMap<String,IUser> {

    abstract List<IUser> getValidUsers();

    abstract void put(IUser user);

    abstract void clearInvalidUsers();
}
