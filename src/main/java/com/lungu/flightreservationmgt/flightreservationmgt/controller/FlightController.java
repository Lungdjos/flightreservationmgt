package com.lungu.flightreservationmgt.flightreservationmgt.controller;

import com.lungu.flightreservationmgt.flightreservationmgt.entities.Flight;
import com.lungu.flightreservationmgt.flightreservationmgt.repos.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {


    // creating the logger instance
    private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
    // injecting the flight repo
    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping("/availableFlights")
    public String findFlights(@RequestParam("from") String from,
                              @RequestParam("to") String to,
                              @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate,
                              ModelMap modelMap){
        // creation of a logger
        LOGGER.info("Inside findFlights() with from: {}, to: {} and departure date: {} incoming values.", from, to, departureDate);
        // calling the find flights methods
        List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
        modelMap.addAttribute("flights", flights);
        LOGGER.info("The found flights are "+flights);
        return "displayFlights";
    }

    // method to add a flight
    @RequestMapping("/admin/addFlight")
    public String showAddFlight(){
        return "addFlight";
    }

}
