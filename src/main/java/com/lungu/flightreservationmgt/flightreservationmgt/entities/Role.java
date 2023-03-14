package com.lungu.flightreservationmgt.flightreservationmgt.entities;

import jakarta.persistence.Entity;

@Entity
public class Role extends AbstractEntity{
    private String name;

    // setter and getter method
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // to string method
    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}
