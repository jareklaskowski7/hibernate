// Hibernate20

package com.jareklaskowski7.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "four_wheeler")
@Table(name = "four_wheelers")
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
