package com.lungu.flightreservationmgt.flightreservationmgt.controller;

import com.lungu.flightreservationmgt.flightreservationmgt.entities.User;
import com.lungu.flightreservationmgt.flightreservationmgt.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    // injecting the user repo
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/showRegistration")
    public String showRegistrationPage(){
        return "login/userRegistration";
    }

    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user){
        userRepository.save(user);
        return "login/loginPage";
    }
}
