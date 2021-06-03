// Hibernate10

package com.jareklaskowski7.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
//import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "user")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
    @Column(name = "user_name")
    private String name;
    @ElementCollection
    private Set<Address> addresses = new HashSet<>();
    //private Set<Address> addresses = new LinkedHashSet<>();
    @Temporal(TemporalType.DATE)
    @Column(name = "user_joined_date")
    private Date joinedDate;
    @Lob
    @Column(name = "user_description")
    private String description;

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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
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
}
