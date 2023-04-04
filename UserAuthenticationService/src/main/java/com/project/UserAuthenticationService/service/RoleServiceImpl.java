package com.project.UserAuthenticationService.service;


import com.project.UserAuthenticationService.domain.Role;
import com.project.UserAuthenticationService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}
