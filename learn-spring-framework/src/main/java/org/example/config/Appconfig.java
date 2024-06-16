package org.example.config;

import org.example.vehicle.Bike;
import org.example.vehicle.Car;
import org.example.vehicle.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class Appconfig {
    @Bean
    public Vehicle car(){
        return new Car();
    }
    @Bean
    public Vehicle bike(){
        return new Bike();
    }
}
