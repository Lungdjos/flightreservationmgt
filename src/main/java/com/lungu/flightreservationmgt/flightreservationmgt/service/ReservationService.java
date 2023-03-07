package com.lungu.flightreservationmgt.flightreservationmgt.service;


import com.itextpdf.text.DocumentException;
import com.lungu.flightreservationmgt.flightreservationmgt.dto.ReservationRequest;
import com.lungu.flightreservationmgt.flightreservationmgt.entities.Reservation;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

public interface ReservationService {
    Reservation bookFlight(ReservationRequest reservationRequest) throws DocumentException, FileNotFoundException, MessagingException;
}
