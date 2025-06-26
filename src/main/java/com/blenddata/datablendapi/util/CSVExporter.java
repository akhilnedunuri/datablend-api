package com.blenddata.datablendapi.util;

import com.blenddata.datablendapi.model.UserCombined;
import com.opencsv.CSVWriter;

import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

public class CSVExporter {

    public static void exportToCSV(HttpServletResponse response, List<UserCombined> users) throws Exception {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=users.csv");

        PrintWriter writer = response.getWriter();
        CSVWriter csvWriter = new CSVWriter(writer);

        String[] header = { "UserId", "Name", "Email", "Phone", "Address", "Occupation", "Interests" };
        csvWriter.writeNext(header);

        for (UserCombined u : users) {
            csvWriter.writeNext(new String[]{
                u.getUserId(), u.getName(), u.getEmail(),
                u.getPhone(), u.getAddress(), u.getOccupation(), u.getInterests()
            });
        }

        csvWriter.close();
    }
}
