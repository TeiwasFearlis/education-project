package ru.education.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Authorization {

    final private UserRepo userRepo;

    final private HashSet<String> methodsBlackList = new HashSet<>(Arrays.asList("hack", "hack2"));

    public Authorization(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    private boolean hackAnalize(Object o) {
        Class clazz = o.getClass();
        String text = Arrays.toString(clazz.getDeclaredMethods());
        String[] array = text.split("\\.");
        ArrayList<String> methods = new ArrayList<>();
        Arrays.stream(array)
                .filter(it->it.contains("("))
                .forEach(it -> methods.add(it.substring(0, it.indexOf("("))));
        return methods.stream().noneMatch(methodsBlackList::contains);
    }

    public boolean auth(User inUser) {
        if (hackAnalize(inUser)) {
            User user = userRepo.getUser(inUser.getLogin());
            if (user != null) {
                return user.getPassword().equals(inUser.getPassword());
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}

