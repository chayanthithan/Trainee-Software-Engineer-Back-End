package com.example.user_management_service.service;

import com.example.user_management_service.api.converter.UserConverter;
import com.example.user_management_service.dto.UserDto;
import com.example.user_management_service.entity.User;
import com.example.user_management_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;


    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUserDetails(UserDto userDto) {
        return userRepository.save(userConverter.convert(userDto));
    }

    public String deleteUserById(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "Successfully deleted";
        }else{
            throw new NullPointerException("there  is no records");
        }
    }
}
