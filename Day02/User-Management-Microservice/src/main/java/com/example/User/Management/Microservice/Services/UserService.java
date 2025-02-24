package com.example.User.Management.Microservice.Services;

import com.example.User.Management.Microservice.Entity.UserEntity;
import com.example.User.Management.Microservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public String getAllUsers() {
        return "list of users are here";
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    public UserEntity addUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
