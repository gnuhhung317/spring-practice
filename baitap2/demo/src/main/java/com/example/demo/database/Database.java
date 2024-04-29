package com.example.demo.database;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repositor.RoleRepository;
import com.example.demo.repositor.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, RoleRepository roleRepository){
        return new CommandLineRunner(){

            @Override
            public void run(String... args) throws Exception {
                Role role = new Role("Admin","can do anything");
                Role role1 = new Role("user","can do something");
                User user = new User("email","hung","password","avatar","phone","address","website","facebook",role);
                User user1 = new User("email","hung dz","password","avatar","phone","address","website","facebook",role1);
                roleRepository.save(role1);
                roleRepository.save(role);
//                userRepository.save(user);
//                userRepository.save(user1);

            }
        };
    }

}
