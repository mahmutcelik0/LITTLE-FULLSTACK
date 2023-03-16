package com.mahmutcelik.bakcend.service.user;

import com.mahmutcelik.bakcend.dto.UserDTO;
import com.mahmutcelik.bakcend.exception.UserNotFoundException;
import com.mahmutcelik.bakcend.model.User;

import java.util.List;

public interface UserService {
    String addNewUser(User user);

    List<UserDTO> getAllUsers() throws UserNotFoundException;

    UserDTO getUserByEmail(String email) throws UserNotFoundException;

    void deleteUserById(Long id) throws UserNotFoundException;

    void deleteUserByEmail(String email) throws UserNotFoundException;
}
