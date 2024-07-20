package com.documentMgmt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.documentMgmt.entity.ConfirmationEntity;
import com.documentMgmt.entity.UserEntity;

@Repository
public interface ConfirmationRepository extends JpaRepository<ConfirmationEntity,Long>{
    
    Optional<ConfirmationEntity> findBytokenKey(String key);
    Optional<ConfirmationEntity> findByUserEntity(UserEntity userEntity);

}
