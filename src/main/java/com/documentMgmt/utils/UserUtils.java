package com.documentMgmt.utils;

import java.time.LocalDateTime;
import java.util.UUID;

import com.documentMgmt.entity.RolesEntity;
import com.documentMgmt.entity.UserEntity;

public class UserUtils {

    public static UserEntity createUserEntity(String firstName,String lastName,String email,RolesEntity role){
        return UserEntity.builder()
                .userId(UUID.randomUUID().toString())
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .lastLogin(LocalDateTime.now())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .mfa(false)
                .enable(false)
                .loginAttempts(0)
                .qrCodeSecret("")
                .phone("")
                .bio("")
                .imageUrl("")
                .role(role)
                .build();

    }
}
