package net.duchung.springboot_restful_webservices.service;

import net.duchung.springboot_restful_webservices.dto.UserDto;
import net.duchung.springboot_restful_webservices.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user);
     boolean deleteUser(Long userId);
}
