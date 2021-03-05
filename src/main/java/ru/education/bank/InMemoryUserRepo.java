package ru.education.bank;

import java.util.*;

public class InMemoryUserRepo implements UserRepo {


    private final Map<String, String> baseLoginPassword;
    {
        baseLoginPassword = new HashMap<>();
        baseLoginPassword.put("Cat", "113");
        baseLoginPassword.put("Dog88", "kopol");
        baseLoginPassword.put("polly", "2145gop");
        baseLoginPassword.put("jf", "dfgfdg");
        baseLoginPassword.put("12345", "3658");
        baseLoginPassword.put("fifa", "6");
        baseLoginPassword.put("top", "tipograf");
        baseLoginPassword.put("Anton90", "1589");
        baseLoginPassword.put("Iop", "545");
    }


    @Override
    public void addNewUser(User user) {
        baseLoginPassword.put(user.getLogin(),user.getPassword());
    }

    @Override
    public User getUser(String login) {
       if (baseLoginPassword.containsKey(login)){
           return new User(login,baseLoginPassword.get(login));
       }else {
           return new User();
       }
    }

    @Override
    public List<User> getUserList() {
      List<User> userList = new ArrayList<>();
        for (String s: baseLoginPassword.keySet()){
            String base = baseLoginPassword.get(s);
            userList.add(new User ( s,base));
        }
        return userList;
    }

    public static void main(String[] args) {
        InMemoryUserRepo in = new InMemoryUserRepo();
        System.out.println(in.getUserList());
    }
}
