package com.lungu.flightreservationmgt.flightreservationmgt.utils;

import com.itextpdf.text.DocumentException;
import com.lungu.flightreservationmgt.flightreservationmgt.entities.Reservation;

import java.io.FileNotFoundException;

public interface PDFGeneratorUtil {
    void generateItinerary(Reservation reservation, String filePath) throws FileNotFoundException, DocumentException;
}
