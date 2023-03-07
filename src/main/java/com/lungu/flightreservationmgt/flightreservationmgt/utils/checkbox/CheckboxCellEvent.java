package com.lungu.flightreservationmgt.flightreservationmgt.utils.checkbox;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;

public class CheckboxCellEvent implements PdfPCellEvent {
    public CheckboxCellEvent(PdfFormField checkbox, int i, int i1) {
    }

    @Override
    public void cellLayout(PdfPCell pdfPCell, Rectangle rectangle, PdfContentByte[] pdfContentBytes) {

    }
}
