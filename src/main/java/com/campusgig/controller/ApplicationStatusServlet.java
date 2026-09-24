package com.campusgig.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/application-status")
public class ApplicationStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String applicationIdText = request.getParameter("applicationId");

        if (applicationIdText == null || applicationIdText.trim().isEmpty()) {
            response.getWriter().println("<h1>Application Status</h1>");
            response.getWriter().println("<p>Application ID is required.</p>");
            response.getWriter().println("<a href='application-status.html'>Go Back</a>");
            return;
        }

        int applicationId;

        try {
            applicationId = Integer.parseInt(applicationIdText);

            if (applicationId <= 0) {
                response.getWriter().println("<h1>Invalid Application ID</h1>");
                response.getWriter().println("<p>Application ID must be greater than 0.</p>");
                response.getWriter().println("<a href='application-status.html'>Go Back</a>");
                return;
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("<h1>Invalid Application ID</h1>");
            response.getWriter().println("<p>Application ID must be a valid number.</p>");
            response.getWriter().println("<a href='application-status.html'>Go Back</a>");
            return;
        }

        // Temporary response.
        // The actual status will be loaded from the database later.
        response.getWriter().println("<h1>Application Status</h1>");
        response.getWriter().println("<p>Application ID: " + applicationId + "</p>");
        response.getWriter().println("<p>Application status will be loaded from the database.</p>");
        response.getWriter().println("<a href='application-status.html'>Back</a>");
    }
}