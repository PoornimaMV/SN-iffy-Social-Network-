package com.example.courseapi.service;

import com.example.courseapi.model.AuthResult;
import com.example.courseapi.model.User;
import com.example.courseapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(long userId) {
        return (User) userRepository.findById(userId).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUsersbyuserid(Long userId) {
        userRepository.deleteById(userId);
    }


    public Boolean authUser(String mailId, String password) {
        Optional<User> userOptional=userRepository.findByMailIdAndPassword(mailId,password);
        if (userOptional.isPresent())
        {
            return true;
        }
        return false;
    }

    public AuthResult authAndReturnUser(String mailId, String password) {

        AuthResult authResult = new AuthResult();
        authResult.setAuthStatus(false);
        authResult.setUser(null);
        Optional<User> userOptional=userRepository.findByMailIdAndPassword(mailId,password);
        if (userOptional.isPresent())
        {
            authResult.setAuthStatus(true);
            authResult.setUser(userOptional.get());
        }
        return authResult;
    }


    public User CreateUser(User user) {
        return userRepository.save(user);

    }

}
