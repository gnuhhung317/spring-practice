package com.example.demo.service.imp;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserServiceImp {
    boolean createUser(String email, String fullname, String password, MultipartFile avatar,String phone, String address,String website,String facebook, int roleId);
    UserDTO getUser(int userId);
    List<UserDTO> getAll();
    boolean updateUser(int userId,UserDTO userDTO);

    boolean deleteUser(int userId);

}
