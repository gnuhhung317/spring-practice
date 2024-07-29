package net.duchung.springboot_restful_webservices.mapper;

import net.duchung.springboot_restful_webservices.dto.UserDto;
import net.duchung.springboot_restful_webservices.entity.User;

public class UserMapper {
    public static User convertToEntity(UserDto userDto){
        return new User(userDto.getId(),userDto.getFirstName(),userDto.getLastName(),userDto.getEmail());
    }
    public static UserDto convertToDto(User user){
        return new UserDto(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail());
    }
}
