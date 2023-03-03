package com.lungu.flightreservationmgt.flightreservationmgt.controller;

import com.lungu.flightreservationmgt.flightreservationmgt.dto.ReservationRequest;
import com.lungu.flightreservationmgt.flightreservationmgt.entities.Flight;
import com.lungu.flightreservationmgt.flightreservationmgt.entities.Reservation;
import com.lungu.flightreservationmgt.flightreservationmgt.repos.FlightRepository;
import com.lungu.flightreservationmgt.flightreservationmgt.repos.ReservationRepository;
import com.lungu.flightreservationmgt.flightreservationmgt.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {
    // injecting repo
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private ReservationService reservationService;

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam(value = "flightId") int flightId, ModelMap modelMap){
        Flight flight = flightRepository.findById(flightId).orElseThrow();
        modelMap.addAttribute("flight", flight);
        return "displayReservationPage";
    }
    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest reservationRequest, ModelMap modelMap){
        Reservation reservation = reservationService.bookFlight(reservationRequest);
        modelMap.addAttribute("msg", "Reservation created successfully! The reservation id is: "+
                reservation.getId());
        return "confirmReservation";
    }
}
