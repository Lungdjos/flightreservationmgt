package com.lungu.flightreservationmgt.flightreservationmgt.controller.rest;

import com.lungu.flightreservationmgt.flightreservationmgt.dto.ReservationUpdateRequest;
import com.lungu.flightreservationmgt.flightreservationmgt.entities.Reservation;
import com.lungu.flightreservationmgt.flightreservationmgt.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReservationRestController {
    @Autowired
    private ReservationRepository reservationRepository;
    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") int id){
        return reservationRepository.findById(id).orElseThrow();
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest reservationUpdateRequest){
        Reservation reservation = reservationRepository.findById(reservationUpdateRequest.getId()).orElseThrow();
        reservation.setNumberOfBags(reservationUpdateRequest.getNumberOfBags());
        reservation.setCheckedIn(reservationUpdateRequest.isCheckedIn());
        return reservationRepository.save(reservation);
    }
}
