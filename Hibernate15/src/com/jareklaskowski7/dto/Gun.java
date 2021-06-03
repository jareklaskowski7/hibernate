// Hibernate15

package com.jareklaskowski7.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "gun")
@Table(name = "guns")
public class Gun {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gun_id")
    private long id;
    @Column(name = "gun_name")
    private String name;
    @ManyToMany
    @JoinTable(name = "gun_users",
            joinColumns = @JoinColumn(name = "gun_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Collection<User> users = new ArrayList<>();

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

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
