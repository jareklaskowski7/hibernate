// Hibernate18

package com.jareklaskowski7.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "four_wheeler")
@DiscriminatorValue("car")
public class FourWheeler extends Vehicle {
    @Column(name = "steering_wheel")
    private String SteeringWheel;

    public String getSteeringWheel() {
        return SteeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        SteeringWheel = steeringWheel;
    }
}
