package by.itacademy.utils;

import by.itacademy.objects.User;

import java.util.HashMap;
import java.util.Map;

public class DAO {
    private static Map<String, User> users = new HashMap<>();
    private DAO(){}

    public static boolean hasUser(String login){
        return users.containsKey(login);
    }

    public static User getUser(String login){
        return users.get(login);
    }

    public static void setUser(String login, String password){
        users.put(login,new User(login,password));
    }
}
