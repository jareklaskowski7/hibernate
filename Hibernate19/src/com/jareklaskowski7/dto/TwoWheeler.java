// Hibernate19

package com.jareklaskowski7.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "two_wheeler")
@Table(name = "two_wheelers")
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
