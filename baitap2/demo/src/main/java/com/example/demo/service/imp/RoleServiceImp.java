package com.example.demo.service.imp;

import com.example.demo.dto.RoleDTO;
import com.example.demo.entity.Role;

import java.util.List;

public interface RoleServiceImp {
    boolean createRole(String name, String description);
    RoleDTO getRole(int id);
    boolean updateRole(int id, RoleDTO roleDTO);
    boolean deleteRole(int id);
    List<RoleDTO> getAll();
}
