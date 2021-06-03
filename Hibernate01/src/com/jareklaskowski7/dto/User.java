// Hibernate01

package com.jareklaskowski7.dto;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "user")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "user_id")
    private long id;
    @Column(name = "user_name")
    //@Basic()
    //@Basic(fetch = )
    //@Basic(optional = )
    //@Transient()
    private String name;
    @Column(name = "user_address")
    private String address;
    @Column(name = "user_joined_date")
    @Temporal(TemporalType.DATE)
    //@Temporal(TemporalType.TIME)
    private Date joinedDate;
    @Column(name = "user_description")
    @Lob
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
