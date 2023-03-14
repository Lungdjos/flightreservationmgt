package com.lungu.flightreservationmgt.flightreservationmgt.service.implementation;

import com.lungu.flightreservationmgt.flightreservationmgt.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {
    // injections
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public boolean login(String username, String password) {
        // loading the user using the userdeatils
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        // creating the user authentication token
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        // authenticating the token
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        // storing the authentication state
        boolean result = usernamePasswordAuthenticationToken.isAuthenticated();
        //
        return result;
    }
}
