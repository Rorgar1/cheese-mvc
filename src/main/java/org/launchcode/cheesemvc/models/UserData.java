package org.launchcode.cheesemvc.models;

import java.util.ArrayList;
import java.util.List;

public class UserData {

    private static List<User> users = new ArrayList<>();

    public UserData() {
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        UserData.users = users;
    }

    public static void addUser(User user) {
        users.add(user);
    }
}