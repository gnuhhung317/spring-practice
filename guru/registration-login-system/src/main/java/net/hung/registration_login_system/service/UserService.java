package net.hung.registration_login_system.service;

import net.hung.registration_login_system.dto.UserDto;
import net.hung.registration_login_system.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void saveUser(UserDto user);
    User findByEmail(String email);
    List<UserDto> getAllUsers();
}
