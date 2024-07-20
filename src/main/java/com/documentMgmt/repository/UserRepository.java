package com.documentMgmt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.documentMgmt.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
    
    Optional<UserEntity> findByEmailIgnoreCase(String email);
    Optional<UserEntity> findUserByUserId(String userId);
}
