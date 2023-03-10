package com.lungu.flightreservationmgt.flightreservationmgt.service.implementation;

import com.itextpdf.text.DocumentException;
import com.lungu.flightreservationmgt.flightreservationmgt.dto.ReservationRequest;
import com.lungu.flightreservationmgt.flightreservationmgt.entities.Flight;
import com.lungu.flightreservationmgt.flightreservationmgt.entities.Passenger;
import com.lungu.flightreservationmgt.flightreservationmgt.entities.Reservation;
import com.lungu.flightreservationmgt.flightreservationmgt.repos.FlightRepository;
import com.lungu.flightreservationmgt.flightreservationmgt.repos.PassengerRepository;
import com.lungu.flightreservationmgt.flightreservationmgt.repos.ReservationRepository;
import com.lungu.flightreservationmgt.flightreservationmgt.service.ReservationService;
import com.lungu.flightreservationmgt.flightreservationmgt.utils.EmailUtil;
import com.lungu.flightreservationmgt.flightreservationmgt.utils.PDFGeneratorUtil;
import jakarta.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    // injecting the utility classes
    @Autowired
    private PDFGeneratorUtil pdfGeneratorUtil;

    @Autowired
    private EmailUtil emailUtil;

    // creating the logger instance
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    // the book flight method
    @Override
    public Reservation bookFlight(ReservationRequest reservationRequest) throws DocumentException, FileNotFoundException, MessagingException {
        // creating a logging
        LOGGER.info("Inside the bookFlight() with incoming value "+reservationRequest);
        // make payment implementation
        // TODO: implementing payment method via third-party payments

        // retrieving a flight
        Flight flight = flightRepository.findById(reservationRequest.getFlightId()).orElseThrow();
        // creating a logging
        LOGGER.info("The found flight " + flight);

        // the passenger obj
        Passenger passenger = new Passenger();
        // creating the passenger
        passenger.setFirstName(reservationRequest.getPassengerFirstName());
        passenger.setLastName(reservationRequest.getPassengerLastName());
        passenger.setEmail(reservationRequest.getPassengerEmail());
        passenger.setPhone(reservationRequest.getPassengerPhone());
        // saving the passenger to the database
        Passenger savedPassenger = passengerRepository.save(passenger);
        // creating a logging
        LOGGER.info("The created passenger "+ passenger);


        Reservation reservation = new Reservation();
        // creating a reservation
        reservation.setFlight(flight);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);
        // saving the reservation
        Reservation savedReservation = reservationRepository.save(reservation);
        // creating a logging
        LOGGER.info("The created reservation "+reservation);

        // creating a file path variable
        String filePath = "D:/Work_Project/reservationutil/Reservation"+savedReservation.getId()+".pdf";

        // creating the pdf file
        pdfGeneratorUtil.generateItinerary(savedReservation, filePath);

        // creating a logging
        LOGGER.info("The location of the saved pdf file "+filePath);

        // sending a mail
//        emailUtil.sendItinerary(passenger.getEmail(), filePath);
        // creating a logging
//        LOGGER.info("Send a mail of the saved pdf file.");

        // creating a logging
        LOGGER.info("The saved reservation is "+ savedReservation);

        return savedReservation;
    }
}
