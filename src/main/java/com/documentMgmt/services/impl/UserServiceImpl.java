package com.documentMgmt.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.documentMgmt.entity.ConfirmationEntity;
import com.documentMgmt.entity.CredentialEntity;
import com.documentMgmt.entity.RolesEntity;
import com.documentMgmt.entity.UserEntity;
import com.documentMgmt.enumeration.Authority;
import com.documentMgmt.enumeration.EventType;
import com.documentMgmt.event.UserEvent;
import com.documentMgmt.exception.ApiException;
import com.documentMgmt.repository.ConfirmationRepository;
import com.documentMgmt.repository.CredentialRepository;
import com.documentMgmt.repository.RoleRepository;
import com.documentMgmt.repository.UserRepository;
import com.documentMgmt.services.UserService;
import com.documentMgmt.utils.UserUtils;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional(rollbackOn = Exception.class)
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private ConfirmationRepository confirmationRepository;

    // @Autowired
    // private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void createUser(String firstName, String lastName, String email, String password) {
       var userEntity = userRepository.save(createNewUser(firstName, lastName, email, password));
       var credentialEntity = new CredentialEntity(userEntity, password);
       credentialRepository.save(credentialEntity);
       var confirmationEntity = new ConfirmationEntity(userEntity);
       confirmationRepository.save(confirmationEntity);
       applicationEventPublisher.publishEvent(new UserEvent(userEntity,EventType.REGISTRATION,Map.of("tokenKey",confirmationEntity.getTokenKey())));
    }

    @Override
    public RolesEntity getRoleName(String roleName) {
        var role = roleRepository.findByNameIgnoreCase(roleName);
        return role.orElseThrow(()-> new ApiException("Roles not found"));
    }

    private UserEntity createNewUser(String firstName,String lastName,String email,String password){
        var role = getRoleName(Authority.USER.name());
        return UserUtils.createUserEntity(firstName, lastName, email, role);
    }

    
    




    
}
