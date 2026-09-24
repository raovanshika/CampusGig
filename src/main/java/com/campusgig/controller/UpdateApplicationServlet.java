package com.campusgig.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update-application")
public class UpdateApplicationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String applicationIdText = request.getParameter("applicationId");
        String status = request.getParameter("status");

        int applicationId;

        try {
            applicationId = Integer.parseInt(applicationIdText);

            if (applicationId <= 0) {
                response.getWriter().println("<h1>Invalid Application ID</h1>");
                response.getWriter().println("<p>Application ID must be greater than 0.</p>");
                response.getWriter().println("<a href='update-application.html'>Go Back</a>");
                return;
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("<h1>Invalid Application ID</h1>");
            response.getWriter().println("<p>Application ID must be a valid number.</p>");
            response.getWriter().println("<a href='update-application.html'>Go Back</a>");
            return;
        }

        if (status == null ||
                (!status.equals("HIRED") && !status.equals("REJECTED"))) {

            response.getWriter().println("<h1>Invalid Status</h1>");
            response.getWriter().println("<p>Status must be Hire or Reject.</p>");
            response.getWriter().println("<a href='update-application.html'>Go Back</a>");
            return;
        }

        // Temporary response.
        // Database status update will be connected later.
        response.getWriter().println("<h1>Application Status Updated</h1>");
        response.getWriter().println("<p>Application ID: " + applicationId + "</p>");
        response.getWriter().println("<p>Status: " + status + "</p>");
        response.getWriter().println("<a href='update-application.html'>Back</a>");
    }
}