package ru.education.bank;

import java.util.HashMap;
import java.util.List;


public abstract class IUserContainer extends HashMap<String, IUser> {

    abstract List<IUser> getValidUsers();

    abstract void clearInvalidUsers();

}
