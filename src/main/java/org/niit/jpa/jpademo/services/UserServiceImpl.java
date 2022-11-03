package org.niit.jpa.jpademo.services;

import org.niit.jpa.jpademo.domain.User;
import org.niit.jpa.jpademo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, String email) {
        Optional<User> opuser=userRepository.findById(email);
        if(opuser.isEmpty()){
            return null;
        }
        User existinguser=opuser.get();
        if (user.getFirstName()!=null){
            existinguser.setFirstName(user.getFirstName());
        }
        if (user.getLastName()!=null){
            existinguser.setLastName(user.getLastName());
        }if (user.getPassword()!=null){
            existinguser.setPassword(user.getPassword());
        }
        return userRepository.save(existinguser);
    }

    @Override
    public boolean deleteUserByEmail(String email) {
        userRepository.deleteById(email);
        return true;
    }

    @Override
    public List<User> getUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}
