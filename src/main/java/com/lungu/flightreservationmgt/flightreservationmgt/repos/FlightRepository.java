package com.lungu.flightreservationmgt.flightreservationmgt.repos;

import com.lungu.flightreservationmgt.flightreservationmgt.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
