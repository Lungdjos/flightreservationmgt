package com.lungu.flightreservationmgt.flightreservationmgt.security.config;

import com.lungu.flightreservationmgt.flightreservationmgt.security.WebSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigImpl extends WebSecurityConfiguration implements WebSecurityConfig {
    // http security configurer
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        // adding all urls that can be accessed by all users and certain users
        httpSecurity.authorizeHttpRequests().requestMatchers("/showRegistration", "/", "/index.html",
                "/registerUser", "/login", "/loginValidation", "/login/*").permitAll().requestMatchers("/admin/*")
                .hasAnyAuthority("Admin").anyRequest().authenticated().and().csrf().disable();
    }
}
