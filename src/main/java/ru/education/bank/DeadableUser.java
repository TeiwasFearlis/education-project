package ru.education.bank;

public abstract class DeadableUser implements IUser {

    protected void check(){
        if (!isValid()) {
            throw new IllegalStateException("User:" + this.getLogin() + " is invalid");
        }
    }
}
