package ru.education.bank;


public class User  {
    private final String login;
    private final String password;
    private final boolean exist;
    private final String balance;

    public User(String login, String password, String balance) {
        this.login = login;
        this.password = password;
        this.exist =true;
        this.balance= balance;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.exist =true;
        this.balance= getBalance();
    }

    public String getBalance() {
        return balance;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString(){
        return "User["+login+";"+password+";"+balance+"]";
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof User){
            User userObj = (User) obj;
            return this.login.equals(userObj.getLogin()) && this.password.equals(userObj.getPassword());
        }else {
            return false;
        }
    }

    public boolean isExist() {
        return exist;
    }
}
