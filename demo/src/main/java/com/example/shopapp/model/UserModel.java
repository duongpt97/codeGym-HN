package com.example.shopapp.model;

import com.example.shopapp.enitty.User;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private List<User> listUsers;

    public UserModel() {
        listUsers = new ArrayList<>();
        listUsers.add(new User(1, "Duong", "mail@.com.vn", 1));
        listUsers.add(new User(2, "Tung", "mail@.com.vn", 2));
        listUsers.add(new User(2, "Hong", "mail@.com.vn", 3));
    }

    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    public List<User> getListUsers() {
        return listUsers;
    }

    public void deleteListUsers(int id) {
        this.listUsers.removeIf(user -> user.getId() == id);
    }

    public void addUsers(User user) {
        this.listUsers.add(user);
    }
}
