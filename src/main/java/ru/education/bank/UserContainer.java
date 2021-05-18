package ru.education.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserContainer extends IUserContainer {

    @Override
    public List<IUser> getValidUsers() {
        List<IUser> container = new ArrayList<>();
        for (String key : keySet()) {
            IUser e = get(key);
            if (e.isValid()) {
                container.add(e);
            }
        }
        return container;
    }

    @Override
    void clearInvalidUsers() {
        Map<String, IUser> freshUsers = new HashMap<>();
        for (IUser user : values()) {
            if (user.isValid()) {
                freshUsers.put(user.getLogin(), user);
            }
        }
        clear();
        putAll(freshUsers);
    }
}
