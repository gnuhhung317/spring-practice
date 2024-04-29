package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repositor.RoleRepository;
import com.example.demo.repositor.UserRepository;
import com.example.demo.service.imp.FileServiceImp;
import com.example.demo.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    UserRepository repository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    FileServiceImp fileServiceImp;
    @Override
    public boolean createUser(String email, String fullname, String password, MultipartFile avatar, String phone, String address, String website, String facebook, int roleId) {
        User user = new User();
        user.setAddress(address);
        user.setAvatar(avatar.getOriginalFilename());
        user.setEmail(email);
        user.setPassword(password);
        user.setFacebook(facebook);
        user.setPhone(phone);
        user.setWebsite(website);
        user.setFullname(fullname);
        Role role = roleRepository.getReferenceById(roleId);
        user.setRole(role);
        boolean isSuccess = fileServiceImp.uploadFile(avatar);
        repository.save(user);
        return isSuccess;
    }

    @Override
    public UserDTO getUser(int userId) {
        User user;
        UserDTO userDTO = new UserDTO();
        if (repository.findById(userId).isPresent()){
            user = repository.findById(userId).get();
            userDTO.setId(user.getId());
            userDTO.setAddress(user.getAddress());
            userDTO.setAvatar(user.getAvatar());
            userDTO.setEmail((user.getEmail()));
            userDTO.setPassword(user.getPassword());
            userDTO.setFacebook(user.getFacebook());
            userDTO.setPhone(user.getPhone());
            userDTO.setWebsite(user.getWebsite());
            userDTO.setRoleId(user.getRole().getId());
            userDTO.setFullname(user.getFullname());
        }else userDTO = null;


        return userDTO;
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO>  userDTOS = new LinkedList<>();
        List<User> users = repository.findAll();
        for (User user : users){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setAddress(user.getAddress());
            userDTO.setAvatar(user.getAvatar());
            userDTO.setEmail((user.getEmail()));
            userDTO.setPassword(user.getPassword());
            userDTO.setFacebook(user.getFacebook());
            userDTO.setPhone(user.getPhone());
            userDTO.setWebsite(user.getWebsite());
            userDTO.setRoleId(user.getRole().getId());
            userDTO.setFullname(user.getFullname());
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public boolean updateUser(int userId,UserDTO userDTO) {
        Optional<User> userOptional = repository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setAddress(userDTO.getAddress());
            user.setAvatar(userDTO.getAvatar());
            user.setEmail((userDTO.getEmail()));
            user.setPassword(userDTO.getPassword());
            user.setFacebook(userDTO.getFacebook());
            user.setPhone(userDTO.getPhone());
            user.setWebsite(userDTO.getWebsite());
            Role role = roleRepository.getReferenceById(userDTO.getRoleId());
            if (role != null) {
                user.setRole(role);
                repository.save(user);
                return true;
            } else {
                // Handle the case where the role doesn't exist
                // You may throw an exception or return false depending on your requirement
                return false;
            }

        }
        return false;



    }

    @Override
    public boolean deleteUser(int userId) {
        if (!repository.findById(userId).isEmpty()){
            repository.deleteById(userId);
            return true;
        }
        return false;
    }

}
