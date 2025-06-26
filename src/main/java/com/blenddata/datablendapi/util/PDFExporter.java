package com.blenddata.datablendapi.util;

import com.blenddata.datablendapi.model.UserCombined;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class PDFExporter {

    public static void exportToPDF(HttpServletResponse response, List<UserCombined> users) throws Exception {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=users.pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        document.add(new Paragraph("User Data Export", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
        document.add(new Paragraph(" ")); // Empty line

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{2, 3, 3, 3, 4, 3, 4});

        String[] headers = { "UserId", "Name", "Email", "Phone", "Address", "Occupation", "Interests" };
        for (String h : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(h));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
        }

        for (UserCombined u : users) {
            table.addCell(u.getUserId());
            table.addCell(u.getName());
            table.addCell(u.getEmail());
            table.addCell(u.getPhone());
            table.addCell(u.getAddress());
            table.addCell(u.getOccupation());
            table.addCell(u.getInterests());
        }

        document.add(table);
        document.close();
    }
}
