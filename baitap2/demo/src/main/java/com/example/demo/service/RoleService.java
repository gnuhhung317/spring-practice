package com.example.demo.service;

import com.example.demo.dto.RoleDTO;
import com.example.demo.entity.Role;
import com.example.demo.repositor.RoleRepository;
import com.example.demo.service.imp.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RoleService implements RoleServiceImp {
    @Autowired
    RoleRepository repository;
    @Override
    public boolean createRole(String name, String description) {
        Role role = new Role();
        role.setName(name);
        role.setDescription(description);
        repository.save(role);
        return true;
    }

    @Override
    public RoleDTO getRole(int id) {
        Role role = null;
        RoleDTO roleDTO = null;
        if (repository.findById(id).isPresent()){
            role = repository.findById(id).get();
            roleDTO = new RoleDTO();
            roleDTO.setDescription(role.getDescription());
            roleDTO.setName(role.getName());
        }

        return roleDTO;
    }

    @Override
    public boolean updateRole(int id,RoleDTO roleDTO) {
        Role role = repository.getReferenceById(id);
        if (!roleDTO.getDescription().isEmpty()) role.setDescription(roleDTO.getDescription());
        if (!roleDTO.getName().isEmpty()) role.setName(role.getName());

        repository.save(role);

        return true;
    }

    @Override
    public boolean deleteRole(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<RoleDTO> getAll() {
        List<Role> roles = repository.findAll();
        List<RoleDTO> roleDTOS = new LinkedList<>();
        for (Role role : roles){
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(role.getId());
            roleDTO.setName(role.getName());
            roleDTO.setDescription(role.getDescription());
            roleDTOS.add(roleDTO);
        }
        return roleDTOS;
    }
}
