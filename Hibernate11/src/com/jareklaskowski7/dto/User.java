// Hibernate11

package com.jareklaskowski7.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
    @ElementCollection
    @JoinTable(name = "user_addresses",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @GenericGenerator(name = "increment-gen", strategy = "increment")
    //@GenericGenerator(name = "product_gen", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    @CollectionId(columns = @Column(name = "address_id"), generator = "increment-gen", type = @Type(type = "long"))
    private Collection<Address> addresses = new ArrayList<>();
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

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
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
