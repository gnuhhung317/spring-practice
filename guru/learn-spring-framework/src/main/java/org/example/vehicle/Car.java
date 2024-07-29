package org.example.vehicle;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("car")
public class Car implements Vehicle{
    @Override
    public void move() {
        System.out.println("Car move!");
    }
}
