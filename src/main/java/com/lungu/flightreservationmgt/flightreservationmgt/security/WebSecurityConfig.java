package com.lungu.flightreservationmgt.flightreservationmgt.security;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.annotation.ImportAware;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface WebSecurityConfig extends ImportAware, BeanClassLoaderAware {
    // http security configurer
    void configure(HttpSecurity httpSecurity) throws Exception;
}
