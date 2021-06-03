// Hibernate19

package com.jareklaskowski7.dto;

import javax.persistence.*;

@Entity(name = "vehicle")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private long id;
    @Column(name = "vehicle_name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
