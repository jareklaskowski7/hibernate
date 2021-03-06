// Hibernate15

package com.jareklaskowski7.dto;

import javax.persistence.*;
import java.util.*;

@Entity(name = "user")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
    @Column(name = "user_name")
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "user_joined_date")
    private Date joinedDate;
    @Lob
    @Column(name = "user_description")
    private String description;
    @OneToMany(mappedBy = "user")
    /*
    @JoinTable(name = "user_vehicles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
     */
    private Collection<Vehicle> vehicles = new ArrayList<>();
    @ManyToMany(mappedBy = "users")
    private Collection<Gun> guns = new ArrayList<>();

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

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Collection<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Collection<Gun> getGuns() {
        return guns;
    }

    public void setGuns(Collection<Gun> guns) {
        this.guns = guns;
    }
}
