package com.lungu.flightreservationmgt.flightreservationmgt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/showRegistration")
    public String showRegistrationPage(){
        return "login/userRegistration";
    }
}
