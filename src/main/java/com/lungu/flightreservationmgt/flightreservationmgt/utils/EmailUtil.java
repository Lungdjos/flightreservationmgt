package com.lungu.flightreservationmgt.flightreservationmgt.utils;

import jakarta.mail.MessagingException;

public interface EmailUtil {
    void sendItinerary(String toAddress, String filePath) throws MessagingException;
}
