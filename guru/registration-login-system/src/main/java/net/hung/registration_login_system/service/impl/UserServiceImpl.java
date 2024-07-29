package net.hung.registration_login_system.service.impl;

import net.hung.registration_login_system.dto.UserDto;
import net.hung.registration_login_system.entity.Role;
import net.hung.registration_login_system.entity.User;
import net.hung.registration_login_system.repository.RoleRepository;
import net.hung.registration_login_system.repository.UserRepository;
import net.hung.registration_login_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = new Role();
        role.setName("ROLE_USER");
        if(roleRepository.findByName("ROLE_USER") == null) {
            roleRepository.save(role);
        }
        role = roleRepository.findByName("ROLE_USER");
        user.getRoles().add(role);

        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(this::toEntity).toList();
    }
    public UserDto toEntity(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
