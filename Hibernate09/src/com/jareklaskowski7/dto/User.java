// Hibernate09

package com.jareklaskowski7.dto;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "user")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
    /*
    @EmbeddedId // Combination of variables
    @Column(name = "user_id")
    private LoginName id;
     */
    @Column(name = "user_name")
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "user_home_address_street_name")),
            @AttributeOverride(name = "city", column = @Column(name = "user_home_address_city_name")),
            @AttributeOverride(name = "state", column = @Column(name = "user_home_address_state_name")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "user_home_address_zip_code_number"))
    })
    private Address homeAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "user_office_address_street_name")),
            @AttributeOverride(name = "city", column = @Column(name = "user_office_address_city_name")),
            @AttributeOverride(name = "state", column = @Column(name = "user_office_address_state_name")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "user_office_address_zip_code_number"))
    })
    private Address officeAddress;
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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
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
