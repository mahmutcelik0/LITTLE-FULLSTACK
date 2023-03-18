package com.mahmutcelik.bakcend.controller;

import com.mahmutcelik.bakcend.dto.UserDTO;
import com.mahmutcelik.bakcend.exception.UserNotFoundException;
import com.mahmutcelik.bakcend.model.User;
import com.mahmutcelik.bakcend.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    private String addNewUser(@RequestBody User user){
        return userService.addNewUser(user);
    }

    @GetMapping
    private List<UserDTO> getAllUsers() throws UserNotFoundException {
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    private List<UserDTO> getUserByEmail(@PathVariable String email) throws UserNotFoundException {
        return userService.getUserByEmail(email);
    }

    @DeleteMapping("/{id}")
    private List<UserDTO> deleteUserById(@PathVariable Long id) throws UserNotFoundException {
        userService.deleteUserById(id);
        List<UserDTO> temp = userService.getAllUsers();
        if(temp.isEmpty()) return null;
        return temp;

    }
    @DeleteMapping("/email/{email}")
    private List<UserDTO> deleteUserByEmail(@PathVariable String email) throws UserNotFoundException{
        userService.deleteUserByEmail(email);
        List<UserDTO> temp = userService.getAllUsers();
        if(temp.isEmpty()) return new ArrayList<>();
        return temp;
    }
}