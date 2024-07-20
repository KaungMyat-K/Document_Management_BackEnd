package com.documentMgmt.services;

import com.documentMgmt.entity.RolesEntity;

public interface UserService {
    
    void createUser(String firstName,String lastName,String email,String password);
    RolesEntity getRoleName(String roleName);
}
