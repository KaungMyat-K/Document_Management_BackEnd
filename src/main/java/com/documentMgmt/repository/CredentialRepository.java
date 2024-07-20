package com.documentMgmt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.documentMgmt.entity.CredentialEntity;


@Repository
public interface CredentialRepository extends JpaRepository<CredentialEntity,Long> {
    
    Optional<CredentialEntity> getCredentialsByUserEntityId(Long userId);
}
