package services;


import dto.UserDto;
import entitities.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}