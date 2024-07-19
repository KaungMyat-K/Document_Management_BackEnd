package com.documentMgmt.enumeration.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

import com.documentMgmt.enumeration.Authority;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Authority,String>{

    @Override
    public String convertToDatabaseColumn(Authority attribute) {
        if(attribute == null){
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public Authority convertToEntityAttribute(String dbData) {
        if(dbData == null){
            return null;
        }
        return Stream.of(Authority.values()).filter(authority->authority.getValue().equals(dbData)).findFirst().orElseThrow(IllegalAccessError::new);
    }
    
}
