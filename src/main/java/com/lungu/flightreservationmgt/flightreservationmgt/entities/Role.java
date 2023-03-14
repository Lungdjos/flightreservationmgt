package com.lungu.flightreservationmgt.flightreservationmgt.entities;

import jakarta.persistence.Entity;

import java.util.Set;

@Entity
public class Role extends AbstractEntity{
    private String name;
    private Set<User> users;

    // setter and getter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    // the to string method
    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
