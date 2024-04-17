package com.documentMgmt.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserEntity extends Auditable{
    
    @Column(updatable = false,unique = true,nullable = false)
    private String userId;

    private String firstName;
    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    private Integer loginAttempts;
    private LocalDateTime lastLogin;
    private String phone;
    private String bio;
    private String imageUrl;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enable;
    private boolean mfa;

    @JsonIgnore
    private String qrCodeSecret;

    @Column(columnDefinition = "TEXT")
    private String qrCodeImageUri;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))
    private RolesEntity role;

    

}
