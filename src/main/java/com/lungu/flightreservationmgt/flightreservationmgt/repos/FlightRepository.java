package com.lungu.flightreservationmgt.flightreservationmgt.repos;

import com.lungu.flightreservationmgt.flightreservationmgt.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    void findFlights(String from, String to, Date departureDate);
}
