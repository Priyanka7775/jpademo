package org.niit.jpa.jpademo.services;

import org.niit.jpa.jpademo.domain.User;

import java.util.List;

public interface UserService {

    public User addUser(User user);
    public List<User> getAllUsers();
    public User updateUser(User user,String email);
    public boolean deleteUserByEmail(String email);
    public List<User> getUserByFirstName(String firstName);
}
