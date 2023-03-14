package com.lungu.flightreservationmgt.flightreservationmgt.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

// the Role class implements the GrantedAuthority from spring security to enforce permissions on operations

@Entity
public class Role extends AbstractEntity implements GrantedAuthority {
    // class attributes
    private String name;
    @ManyToMany(mappedBy = "roles")
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

    // the method that shows the granted role
    @Override
    public String getAuthority() {
        return name;
    }
}
