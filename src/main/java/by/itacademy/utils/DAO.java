package by.itacademy.utils;

import by.itacademy.objects.User;

import java.util.HashMap;
import java.util.Map;

public class DAO {
    private static Map<String, User> users = new HashMap<>();
    private DAO(){}

    public static User getUser(String login){
        setUser("admin", "admin"); //дефолтовый пользователь
        return users.get(login);
    }

    public static void setUser(String login, String password){
        users.put(login,new User(login,password));
    }
}
