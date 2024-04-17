package com.documentMgmt.enumeration;

import static com.documentMgmt.constant.Constants.ADMIN_AUTHORITIES;
import static com.documentMgmt.constant.Constants.MANAGER_AUTHORITIES;
import static com.documentMgmt.constant.Constants.SUPER_ADMIN_AUTHORITIE_STRING;
import static com.documentMgmt.constant.Constants.USER_AUTHORITIES;

public enum Authority {
    
    USER(USER_AUTHORITIES),
    ADMIN(ADMIN_AUTHORITIES),
    SUPER_ADMIN(SUPER_ADMIN_AUTHORITIE_STRING),
    MANAGER(MANAGER_AUTHORITIES);

    private final String value;

    Authority(String value){
        this.value=value;
    }

    public String getValue(){
        return this.value;
    }


}
