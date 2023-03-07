package com.lungu.flightreservationmgt.flightreservationmgt.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lungu.flightreservationmgt.flightreservationmgt.entities.Reservation;
import org.springframework.stereotype.Component;

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
        document.add(new PdfPTable(3));

        // closing
        document.close();
    }
}
