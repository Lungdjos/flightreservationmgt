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

    // the book flight method
    @Override
    public Reservation bookFlight(ReservationRequest reservationRequest) throws DocumentException, FileNotFoundException, MessagingException {
        // make payment implementation
        // TODO: implementing payment method via third-party payments

        // retrieving a flight
        Flight flight = flightRepository.findById(reservationRequest.getFlightId()).orElseThrow();

        // the passenger obj
        Passenger passenger = new Passenger();
        // creating the passenger
        passenger.setFirstName(reservationRequest.getPassengerFirstName());
        passenger.setLastName(reservationRequest.getPassengerLastName());
        passenger.setEmail(reservationRequest.getPassengerEmail());
        passenger.setPhone(reservationRequest.getPassengerPhone());
        // saving the passenger to the database
        Passenger savedPassenger = passengerRepository.save(passenger);


        Reservation reservation = new Reservation();
        // creating a reservation
        reservation.setFlight(flight);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);
        // saving the reservation
        Reservation savedReservation = reservationRepository.save(reservation);
        // creating a file path variable
        String filePath = "D:/Work_Project/reservationutil/Reservation"+savedReservation.getId()+".pdf";

        // creating the pdf file
        pdfGeneratorUtil.generateItinerary(savedReservation, filePath);

        // sending a mail
//        emailUtil.sendItinerary(passenger.getEmail(), filePath);
        return savedReservation;
    }
}
