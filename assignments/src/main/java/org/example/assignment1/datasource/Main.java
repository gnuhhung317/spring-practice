package org.example.assignment1.datasource;

import org.example.assignment1.datasource.AppConfig;
import org.example.assignment1.datasource.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(Client.class).sendEmail();
    }
}