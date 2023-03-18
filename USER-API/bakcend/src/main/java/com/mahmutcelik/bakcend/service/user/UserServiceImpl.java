package com.mahmutcelik.bakcend.service.user;

import com.mahmutcelik.bakcend.dto.UserDTO;
import com.mahmutcelik.bakcend.dto.UserDTOMapper;
import com.mahmutcelik.bakcend.exception.UserNotFoundException;
import com.mahmutcelik.bakcend.model.User;
import com.mahmutcelik.bakcend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String addNewUser(User user) {

        if(userRepository.existsControl(user.getName(),user.getEmail(),user.getDomain(),user.getExperience()))
            return "USER ALREADY EXIST";
        userRepository.save(user);
        return "USER "+user.getName() + " ADDED TO USERS";
    }

    @Override
    public List<UserDTO> getAllUsers(){
        List<User> temp = userRepository.findAll();
        if(temp.isEmpty()) return new ArrayList<>();
        return temp.stream().map(e ->new UserDTOMapper().apply(e)).toList();
    }

    @Override
    public List<UserDTO> getUserByEmail(String email) throws UserNotFoundException {
        Optional<User> temp = userRepository.findByEmail(email);
        return Collections.singletonList(new UserDTOMapper().apply(temp.get()));
    }

    @Override
    public void deleteUserById(Long id) throws UserNotFoundException {
        Optional<User> temp = userRepository.findById(id);
        if(temp.isEmpty()) throw new UserNotFoundException();
        userRepository.deleteById(id);
    }

    @Override
    public void deleteUserByEmail(String email) throws UserNotFoundException {
        Optional<User> temp = userRepository.findByEmail(email);
        if(temp.isEmpty()) throw new UserNotFoundException();
        userRepository.deleteByEmail(email);
    }
}
