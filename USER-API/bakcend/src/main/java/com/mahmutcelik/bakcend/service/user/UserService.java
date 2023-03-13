package com.mahmutcelik.bakcend.service.user;

import com.mahmutcelik.bakcend.exception.UserNotFoundException;
import com.mahmutcelik.bakcend.model.User;

import java.util.List;

public interface UserService {
    String addNewUser(User user);

    List<User> getAllUsers() throws UserNotFoundException;

    User getUserByEmail(String email) throws UserNotFoundException;

    User deleteUserById(Long id) throws UserNotFoundException;
}
