package com.lungu.flightreservationmgt.flightreservationmgt.utils.implementation;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lungu.flightreservationmgt.flightreservationmgt.entities.Reservation;
import com.lungu.flightreservationmgt.flightreservationmgt.utils.PDFGeneratorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Component
public class PDFGeneratorImpl implements PDFGeneratorUtil {
    // creating the logger instance
    private static final Logger LOGGER = LoggerFactory.getLogger(PDFGeneratorImpl.class);
    // to create a pdf file
    @Override
    public void generateItinerary(Reservation reservation, String filePath) throws FileNotFoundException, DocumentException {
        // creating a logging
        LOGGER.info("Inside the generateItinerary() with incoming values reservation: {} and file path {}", reservation, filePath);

        // creating a logging
        LOGGER.info("Creating a document");
        Document document = new Document();

        // creating a logging
        LOGGER.info("A document writer method");
        // writing the document
        PdfWriter.getInstance(document, new FileOutputStream(filePath));

        // creating a logging
        LOGGER.info("Opening the document");
        // opening a document
        document.open();

        // creating a logging
        LOGGER.info("Adding the table content to the document");
        // structuring the document layout
        document.add(createTable(reservation));

        // creating a logging
        LOGGER.info("Closing the document");
        // closing
        document.close();
    }

    // method to create a table
    private PdfPTable createTable(Reservation reservation) {
        // creating a logging
        LOGGER.info("Inside the createTable method that takes the reservation value of: "+reservation);

        // creating the table obj
        PdfPTable createPdfTable = new PdfPTable(2);
        // creating a logging
        LOGGER.info("The created pdf table :"+createPdfTable);

        PdfPCell tableCell;

        // creating a logging
        LOGGER.info("Creating the table cells with values in it");
        // creating a table cell obj and the fields
        tableCell = new PdfPCell(new Phrase("FLIGHT ITINERARY"));
        tableCell.setColspan(2);
        createPdfTable.addCell(tableCell);

        // flight details
        tableCell = new PdfPCell(new Phrase("FLIGHT DETAILS"));
        tableCell.setColspan(2);
        createPdfTable.addCell(tableCell);
        createPdfTable.addCell("Flight No.:");
        createPdfTable.addCell(reservation.getFlight().getFlightNumber());
        createPdfTable.addCell("Operating Airline:");
        createPdfTable.addCell(reservation.getFlight().getOperatingAirlines());
        createPdfTable.addCell("Departure City:");
        createPdfTable.addCell(reservation.getFlight().getDepartureCity());
        createPdfTable.addCell("Arrival City:");
        createPdfTable.addCell(reservation.getFlight().getArrivalCity());
        createPdfTable.addCell("Estimated Departure Time:");
        createPdfTable.addCell(String.valueOf(reservation.getFlight().getEstimatedDepartureTime()));

        // passenger details
        tableCell = new PdfPCell(new Phrase("PASSENGER DETAILS"));
        tableCell.setColspan(2);
        createPdfTable.addCell(tableCell);
        createPdfTable.addCell("First Name:");
        createPdfTable.addCell(reservation.getPassenger().getFirstName());
        createPdfTable.addCell("Middle Name:");
        createPdfTable.addCell(reservation.getPassenger().getMiddleName());
        createPdfTable.addCell("Last Name:");
        createPdfTable.addCell(reservation.getPassenger().getLastName());
        createPdfTable.addCell("Email:");
        createPdfTable.addCell(reservation.getPassenger().getEmail());
        createPdfTable.addCell("Contact No.:");
        createPdfTable.addCell(reservation.getPassenger().getPhone());

        // reservation details
        tableCell = new PdfPCell(new Phrase("RESERVATION DETAILS"));
        tableCell.setColspan(2);
        createPdfTable.addCell(tableCell);
        createPdfTable.addCell("Number of Bags:");
        createPdfTable.addCell(String.valueOf(reservation.getNumberOfBags()));
        createPdfTable.addCell("Time of Creation:");
        createPdfTable.addCell(String.valueOf(reservation.getCreated()));

//        createPdfTable.addCell("Checked In:");
//        PdfFormField checkbox = PdfFormField.createCheckBox(writer);
//        checkbox.setFieldName("myCheckbox");
//        tableCell.setCellEvent(new CheckboxCellEvent(checkbox, 10, 10));
//        createPdfTable.addCell(tableCell);

        // creating a logging
        LOGGER.info("The table created is: " + createPdfTable);

        return createPdfTable;
    }
}
