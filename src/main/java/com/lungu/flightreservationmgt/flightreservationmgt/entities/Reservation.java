package com.lungu.flightreservationmgt.flightreservationmgt.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "reservation")
public class Reservation extends AbstractEntity{
    // class attributes
    private boolean checkedIn;
    private int numberOfBags;
    @OneToOne
    private Passenger passengerId;
    @OneToOne
    private Flight flightId;
    private Timestamp created;

    // getters and setters

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

}
