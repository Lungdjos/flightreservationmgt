package com.lungu.flightreservationmgt.flightreservationmgt.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "reservation")
public class Reservation {
    // class attributes
    private int id;
    private boolean checkedIn;
    private int numberOfBags;
    private Passenger passengerId;
    private Flight flightId;
    private Timestamp created;

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public Passenger getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Passenger passengerId) {
        this.passengerId = passengerId;
    }

    public Flight getFlightId() {
        return flightId;
    }

    public void setFlightId(Flight flightId) {
        this.flightId = flightId;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    // to string method

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkedIn=" + checkedIn +
                ", numberOfBags=" + numberOfBags +
                ", passengerId=" + passengerId +
                ", flightId=" + flightId +
                ", created=" + created +
                '}';
    }
}
