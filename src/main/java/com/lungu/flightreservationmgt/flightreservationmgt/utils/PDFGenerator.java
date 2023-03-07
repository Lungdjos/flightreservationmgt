package com.lungu.flightreservationmgt.flightreservationmgt.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lungu.flightreservationmgt.flightreservationmgt.entities.Reservation;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Component
public class PDFGenerator {
    // to create a pdf file
    public void generateItinerary(Reservation reservation, String filePath) throws FileNotFoundException, DocumentException {
        Document document = new Document();

        // writing the document
        PdfWriter.getInstance(document, new FileOutputStream(filePath));

        // opening a document
        document.open();

        // structuring the document layout
        document.add(createTable(reservation));

        // closing
        document.close();
    }

    // method to create a table
    private PdfPTable createTable(Reservation reservation) {
        // creating the table obj
        PdfPTable createPdfTable = new PdfPTable(2);

        PdfPCell tableCell;
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
//        createPdfTable.addCell(cell);


        return createPdfTable;
    }
}
