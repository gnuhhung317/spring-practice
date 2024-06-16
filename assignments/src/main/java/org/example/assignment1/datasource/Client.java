package org.example.assignment1.datasource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Client {
    @Autowired
    EmailService emailService;
    public void sendEmail(){
        emailService.sendEmail();
    }
}
