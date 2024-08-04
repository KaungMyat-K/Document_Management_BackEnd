package com.documentMgmt.event.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.documentMgmt.event.UserEvent;
import com.documentMgmt.services.EmailService;

@Component
public class UserEventListener {
    
    @Autowired
    private EmailService emailService;

    @EventListener
    public void onUserEvent(UserEvent userEvent){
        switch (userEvent.getType()) {

            case REGISTRATION -> emailService.sendNewAccountEmail(userEvent.getUser().getFirstName(),userEvent.getUser().getEmail(),(String)userEvent.getData().get("tokenKey"));

            case RESETPASSWORD -> emailService.sendPasswordResetEmail(userEvent.getUser().getFirstName(),userEvent.getUser().getEmail(),(String)userEvent.getData().get("tokenKey"));

            default -> {}
        }
    }
}
