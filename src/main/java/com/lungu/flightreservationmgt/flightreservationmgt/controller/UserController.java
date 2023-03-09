package com.lungu.flightreservationmgt.flightreservationmgt.controller;

import com.lungu.flightreservationmgt.flightreservationmgt.entities.User;
import com.lungu.flightreservationmgt.flightreservationmgt.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    // injecting the user repo
    @Autowired
    private UserRepository userRepository;

    // creating the logger instance
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    // method that handles the registration page
    @RequestMapping("/showRegistration")
    public String showRegistrationPage(){
        return "login/userRegistration";
    }

    // method to handle saving the registered user
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user){
        userRepository.save(user);
        return "login/loginPage";
    }
    // method to show the login page
    @RequestMapping("/login")
    public String login(){return "login/loginPage";}

    // the method that display after successful login
    @RequestMapping(value = "/loginValidation", method = RequestMethod.POST)
    public String login(@RequestParam("username") String email,
                        @RequestParam("password") String password,
                        ModelMap modelMap){
        String returnValue; // the return value local variable

        // implementing the logger levels
        LOGGER.error("ERROR");
        LOGGER.warn("WARN");
        LOGGER.info("INFO");    // with SLF4J ends on this level
        LOGGER.debug("DEBUG");
        LOGGER.trace("TRACE");

        User user = userRepository.findByEmail(email);
        // comparing the user inputs with tha data in the database
        if(user.getPassword().equals(password)){
            returnValue = "findFlights";
        }else {
            modelMap.addAttribute("msg", "Invalid username or password. Please try again.");
            returnValue = "login/login";
        }
        return returnValue;
    }
}
