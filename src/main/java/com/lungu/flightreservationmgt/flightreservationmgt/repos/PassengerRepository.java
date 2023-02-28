package com.lungu.flightreservationmgt.flightreservationmgt.repos;

import com.lungu.flightreservationmgt.flightreservationmgt.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
