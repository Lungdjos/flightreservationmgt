package com.lungu.flightreservationmgt.flightreservationmgt.repos;

import com.lungu.flightreservationmgt.flightreservationmgt.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
