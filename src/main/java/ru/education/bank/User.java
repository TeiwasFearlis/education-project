package ru.education.bank;


public class User  {
    private final String login;
    private final String password;
    private final boolean exist;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.exist =true;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString(){
        return "User["+login+";"+password+"]";
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
