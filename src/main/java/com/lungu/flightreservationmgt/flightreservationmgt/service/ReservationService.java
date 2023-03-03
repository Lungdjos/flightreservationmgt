package com.lungu.flightreservationmgt.flightreservationmgt.service;


import com.lungu.flightreservationmgt.flightreservationmgt.dto.ReservationRequest;
import com.lungu.flightreservationmgt.flightreservationmgt.entities.Reservation;
import org.springframework.stereotype.Service;

public interface ReservationService {
    Reservation bookFlight(ReservationRequest reservationRequest);
}
