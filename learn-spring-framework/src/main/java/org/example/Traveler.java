package org.example;

import org.example.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("traveler")
public class Traveler {
    private Vehicle vehicle;

    @Autowired
    public Traveler (@Qualifier("car") Vehicle vehicle){
        this.vehicle = vehicle;
    }
    public void start(){
        vehicle.move();
    }
}
