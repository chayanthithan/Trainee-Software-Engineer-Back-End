package com.example.user_management_service.api.controller;

import com.example.user_management_service.dto.UserDto;
import com.example.user_management_service.entity.User;
import com.example.user_management_service.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testGetAllUser_whenReturnUser(){
        User user = User.builder()
                .userId(1L)
                .name("test")
                .role("ADMIN")
                .build();
       when(userService.getAllUser()).thenReturn(List.of(user));
       List<User> userResponse = userController.getAllUser();

       assertNotNull(userResponse);
       assertEquals("ADMIN",userResponse.get(0).getRole());
    }
    @Test
    void testGetAllUser_whenReturnEmpty(){
       when(userService.getAllUser()).thenReturn(new ArrayList<>());
       List<User> userResponse = userController.getAllUser();

       assertTrue(userResponse.isEmpty());
    }

    @Test
    void testGetUserById_whenUserExist(){
        User user = User.builder()
                .userId(1L)
                .name("test")
                .role("ADMIN")
                .build();
        when(userService.getUserById(user.getId())).thenReturn(Optional.of(user));
        Optional<User> userResponse = userController.getUserById(user.getId());
        assertEquals("test",userResponse.get().getName());
        assertNotNull(userResponse);
    }
    @Test
    void testGetUserById_whenUserNotExist(){
        User user = User.builder()
                .userId(1L)
                .name("test")
                .role("ADMIN")
                .build();
        when(userService.getUserById(user.getId())).thenReturn(Optional.empty());
        Optional<User> userResponse = userController.getUserById(user.getId());
        assertTrue(userResponse.isEmpty());
    }

    @Test
    void testAddUserDetails(){
        UserDto userDto = UserDto.builder()
                .name("test")
                .role("ADMIN")
                .build();
        User user = User.builder()
                .userId(1L)
                .name("test")
                .role("ADMIN")
                .build();
        when(userService.saveUserDetails(any(UserDto.class))).thenReturn(user);
        User response = userController.addUserDetails(userDto);

        assertNotNull(response);
        assertEquals("test",response.getName());
    }

    @Test
    void testDeleteUserById(){
        Long id = 1L;
        when(userService.deleteUserById(id)).thenReturn("Successfully deleted");
        String response = userController.deleteUser(id);

        assertEquals("Successfully deleted",response);
    }

}