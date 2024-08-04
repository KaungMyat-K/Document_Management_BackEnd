package com.documentMgmt.utils;

public class EmailUtils {
    
    public static String getEmailMessage(String name,String host,String key){
        return "Hello"+name+",\n\nYour new account has been created.Please click on the link below to verify your account. \n\n"+getVerificationUrl(host,key)+"\n\n The Support Team";
    }

    public static String getResetPasswordMessage(String name,String host,String key){
        return "Hello"+name+",\n\nPlease click on the link below to change your password. \n\n"+getResetPasswordUrl(host,key)+"\n\n The Support Team";
    }

    public static String getVerificationUrl(String host,String key){
        return host+"/verify/account?key="+key;
    }

    public static String getResetPasswordUrl(String host,String key){
        return host+"/verify/password?key="+key;
    }
}
