package com.lungu.flightreservationmgt.flightreservationmgt.repos;

import com.lungu.flightreservationmgt.flightreservationmgt.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    // using the JPQL query to pull data from the database
    @Query("from Flight where departureCity = :departureCity and arrivalCity = :arrivalCity and dateOfDeparture = :dateOfDeparture")
    // mapping the parameters to the names in the query
    List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to, @Param("dateOfDeparture") Date departureDate);
}
