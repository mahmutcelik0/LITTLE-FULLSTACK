package com.mahmutcelik.bakcend.dto;

import com.mahmutcelik.bakcend.model.User;
import org.springframework.stereotype.Service;
import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User,UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getDomain(),
                user.getEmail(),
                user.getExperience(),
                user.getName()
        );
    }
}
