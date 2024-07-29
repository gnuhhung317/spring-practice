package net.duchung.springboot_restful_webservices.service.imp;

import net.duchung.springboot_restful_webservices.dto.UserDto;
import net.duchung.springboot_restful_webservices.entity.User;
import net.duchung.springboot_restful_webservices.exception.EmailAlreadyExistException;
import net.duchung.springboot_restful_webservices.exception.ResourceNotFoundException;
import net.duchung.springboot_restful_webservices.mapper.AutoUserMapper;
import net.duchung.springboot_restful_webservices.mapper.UserMapper;
import net.duchung.springboot_restful_webservices.repository.UserRepository;
import net.duchung.springboot_restful_webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;
    @Override
    public UserDto createUser(UserDto userDto) {
        repository.findByEmail(userDto.getEmail()).ifPresent(
                (email) -> {throw new EmailAlreadyExistException(userDto.getEmail());}
        );
        return AutoUserMapper.MAPPER.mapToUserDto(repository.save(AutoUserMapper.MAPPER.mapToUser(userDto)));
    }

    @Override
    public UserDto getUserById(Long id) {
       User User = repository.findById(id).orElseThrow(
               () -> new ResourceNotFoundException("user","id",id)
       );
        return AutoUserMapper.MAPPER.mapToUserDto(User);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return repository.findAll().stream().map(AutoUserMapper.MAPPER::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        if(repository.findByEmail(userDto.getEmail()).isPresent()){
            throw new EmailAlreadyExistException(userDto.getEmail());
        }
        User existingUser = repository.findById(userDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("user","id",userDto.getId())
        );
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        return AutoUserMapper.MAPPER.mapToUserDto(repository.save(existingUser));
    }

    @Override
    public boolean deleteUser(Long userId) {
        User existingUser = repository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("user","id",userId)
        );
        repository.deleteById(userId);
        return true;
    }
}
