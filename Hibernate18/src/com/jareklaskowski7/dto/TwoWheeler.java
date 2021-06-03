// Hibernate18

package com.jareklaskowski7.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "two_wheeler")
@DiscriminatorValue("bike")
public class TwoWheeler extends Vehicle {
    @Column(name = "steering_handle")
    private String SteeringHandle;

    public String getSteeringHandle() {
        return SteeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        SteeringHandle = steeringHandle;
    }
}
