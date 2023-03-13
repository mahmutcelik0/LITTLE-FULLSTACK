package com.mahmutcelik.bakcend.controller;

import com.mahmutcelik.bakcend.exception.UserNotFoundException;
import com.mahmutcelik.bakcend.model.User;
import com.mahmutcelik.bakcend.service.user.UserService;
import org.springframework.web.bind.annotation.*;

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
    private List<User> getAllUsers() throws UserNotFoundException {
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    private User getUserByEmail(@PathVariable String email) throws UserNotFoundException {
        return userService.getUserByEmail(email);
    }

    @DeleteMapping("/{id}")
    private User deleteUserById(@PathVariable Long id) throws UserNotFoundException {
        return userService.deleteUserById(id);
    }
}