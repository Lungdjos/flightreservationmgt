package com.lungu.flightreservationmgt.flightreservationmgt.service.implementation;

import com.lungu.flightreservationmgt.flightreservationmgt.entities.User;
import com.lungu.flightreservationmgt.flightreservationmgt.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    // injections
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // loading the user from the database
        User user = userRepository.findByEmail(username);
        // implementing exception handling
        if(user == null){
            throw new UsernameNotFoundException("User not found got the email "+username+" provided!");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), user.getRoles());
    }
}
