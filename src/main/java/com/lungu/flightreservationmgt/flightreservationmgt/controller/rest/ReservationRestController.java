package com.lungu.flightreservationmgt.flightreservationmgt.controller.rest;

import com.lungu.flightreservationmgt.flightreservationmgt.controller.UserController;
import com.lungu.flightreservationmgt.flightreservationmgt.dto.ReservationUpdateRequest;
import com.lungu.flightreservationmgt.flightreservationmgt.entities.Reservation;
import com.lungu.flightreservationmgt.flightreservationmgt.repos.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReservationRestController {

    // creating the logger instance
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

    // injections
    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") int id){
        // creation of a logger
        LOGGER.info("Inside findReservation() with id: " + id);
        return reservationRepository.findById(id).orElseThrow();
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest reservationUpdateRequest){
        // creation of a logger
        LOGGER.info("Inside updateReservation() with incoming reservation: "+reservationUpdateRequest);

        // retrieving a reservation to be updated using the id
        Reservation reservation = reservationRepository.findById(reservationUpdateRequest.getId()).orElseThrow();
        // attributes to update
        reservation.setNumberOfBags(reservationUpdateRequest.getNumberOfBags());
        reservation.setCheckedIn(reservationUpdateRequest.isCheckedIn());
        // saving the updates
        return reservationRepository.save(reservation);
    }
}
