package com.documentMgmt.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.documentMgmt.exception.ApiException;
import com.documentMgmt.services.EmailService;
import com.documentMgmt.utils.EmailUtils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class EmailServiceImpl implements EmailService{

    private static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account Verification";
    private static final String PASSWORD_RESET_REQUEST = "Reset Password Request";

    @Autowired
    private JavaMailSender javaMailSender;    

    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    @Async
    public void sendNewAccountEmail(String name, String email, String token) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            message.setFrom(fromEmail);
            message.setTo(email);
            message.setText(EmailUtils.getEmailMessage(name, email, token));
            javaMailSender.send(message);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Unable to send email");
        }
    }

    @Override
    @Async
    public void sendPasswordResetEmail(String name, String email, String token) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(PASSWORD_RESET_REQUEST);
            message.setFrom(fromEmail);
            message.setTo(email);
            message.setText(EmailUtils.getResetPasswordMessage(name, email, token));
            javaMailSender.send(message);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Unable to send email");
        }
    }
    
}
