package com.duchung.todo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderImpl {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder( );
        System.out.println(        encoder.encode("hung.bd225193@sis.hust.edu.vn")
);
    }
}
