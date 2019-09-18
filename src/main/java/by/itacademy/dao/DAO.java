package by.itacademy.dao;

import by.itacademy.model.User;

import java.util.HashMap;
import java.util.Map;

public class DAO {
    private Map<String, User> users = new HashMap<>();
    private DAO(){}

    private static final DAO dao = new DAO();

    public static DAO getInstance(){
        return dao;
    }

    public boolean hasUser(String login){
        return users.containsKey(login);
    }

    public User getUser(String login){
        return users.get(login);
    }

    public void save(String login, String password){
        users.put(login,new User(login,password));
    }
}
