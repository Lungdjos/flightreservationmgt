package com.lungu.flightreservationmgt.flightreservationmgt.dto;



public class ReservationUpdateRequest {
    private int id;
    private boolean checkedIn;
    private int numberOfBags;

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

    // to string method

    @Override
    public String toString() {
        return "ReservationUpdateRequest{" +
                "id=" + id +
                ", checkedIn=" + checkedIn +
                ", numberOfBags=" + numberOfBags +
                '}';
    }
}
