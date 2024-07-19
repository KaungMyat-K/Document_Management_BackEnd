package com.documentMgmt.event;

import java.util.Map;

import com.documentMgmt.entity.UserEntity;
import com.documentMgmt.enumeration.EventType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserEvent {
    
    private UserEntity user;
    private EventType type;
    private Map<?,?> data;
}
