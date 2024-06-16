package org.example.assignment1.datasource;

import org.example.assignment1.datasource.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    @Autowired
    DataSource dataSource;
    public void sendEmail(){
        for (String email : dataSource.getEmails()){
            System.out.println(email);
        }
    }
}
