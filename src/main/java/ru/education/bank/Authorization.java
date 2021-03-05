package ru.education.bank;

public class Authorization {

   final private UserRepo userRepo;

    public Authorization(UserRepo userRepo) {
        this.userRepo=userRepo;
    }

    public boolean auth(String login, String password) {
        User user = userRepo.getUser(login);
        if (user.isExist()) {
            return user.getPassword().equals(password);
        }else {
            return false;
        }
    }

}