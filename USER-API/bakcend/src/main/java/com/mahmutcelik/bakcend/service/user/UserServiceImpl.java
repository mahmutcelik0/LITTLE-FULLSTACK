package com.mahmutcelik.bakcend.service.user;

import com.mahmutcelik.bakcend.exception.UserNotFoundException;
import com.mahmutcelik.bakcend.model.User;
import com.mahmutcelik.bakcend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<User> getAllUsers() throws UserNotFoundException {
        List<User> temp = userRepository.findAll();
        if(temp.isEmpty()) throw new UserNotFoundException();
        return temp;
    }

    @Override
    public User getUserByEmail(String email) throws UserNotFoundException {
        User temp = userRepository.findByEmail(email);
        if(temp == null) throw new UserNotFoundException();
        return temp;
    }

    @Override
    public User deleteUserById(Long id) throws UserNotFoundException {
        Optional<User> temp = userRepository.findById(id);
        if(temp.isEmpty()) throw new UserNotFoundException();
        userRepository.deleteById(id);
        return temp.get();
    }
}
