package com.blenddata.datablendapi.controller;

import com.blenddata.datablendapi.model.UserCombined;
import com.blenddata.datablendapi.service.UserService;
import com.blenddata.datablendapi.util.CSVExporter;
import com.blenddata.datablendapi.util.PDFExporter;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ Endpoint 1: Get merged user data as JSON
    @GetMapping("/all")
    public List<UserCombined> getAllUsers() {
        return userService.getAllCombinedUsers();
    }

    // ✅ Endpoint 2: Export CSV
    @GetMapping("/export/csv")
    public void exportCSV(HttpServletResponse response) throws Exception {
        List<UserCombined> users = userService.getAllCombinedUsers();
        CSVExporter.exportToCSV(response, users);
    }

    // ✅ Endpoint 3: Export PDF
    @GetMapping("/export/pdf")
    public void exportPDF(HttpServletResponse response) throws Exception {
        List<UserCombined> users = userService.getAllCombinedUsers();
        PDFExporter.exportToPDF(response, users);
    }
}
