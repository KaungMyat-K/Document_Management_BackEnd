package com.documentMgmt.enumeration;

import com.documentMgmt.constant.Constants;

public enum Authority {
    
    USER(Constants.USER_AUTHORITIES),
    ADMIN(Constants.ADMIN_AUTHORITIES),
    SUPER_ADMIN(Constants.SUPER_ADMIN_AUTHORITIE_STRING),
    MANAGER(Constants.MANAGER_AUTHORITIES);


    private final String value;

    Authority(String value){
        this.value=value;
    }

    public String getValue(){
        return this.value;
    }


}
