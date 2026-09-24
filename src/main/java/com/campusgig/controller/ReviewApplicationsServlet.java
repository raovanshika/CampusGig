package com.campusgig.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/review-applications")
public class ReviewApplicationsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String gigIdText = request.getParameter("gigId");

        if (gigIdText == null || gigIdText.trim().isEmpty()) {
            response.getWriter().println("<h1>Review Applications</h1>");
            response.getWriter().println("<p>Gig ID is required.</p>");
            response.getWriter().println("<a href='review-applications.html'>Go Back</a>");
            return;
        }

        int gigId;

        try {
            gigId = Integer.parseInt(gigIdText);

            if (gigId <= 0) {
                response.getWriter().println("<h1>Invalid Gig ID</h1>");
                response.getWriter().println("<p>Gig ID must be greater than 0.</p>");
                response.getWriter().println("<a href='review-applications.html'>Go Back</a>");
                return;
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("<h1>Invalid Gig ID</h1>");
            response.getWriter().println("<p>Gig ID must be a valid number.</p>");
            response.getWriter().println("<a href='review-applications.html'>Go Back</a>");
            return;
        }

        response.getWriter().println("<h1>Applications for Gig " + gigId + "</h1>");
        response.getWriter().println("<p>Application data will be loaded here.</p>");
        response.getWriter().println("<a href='review-applications.html'>Back to Review</a>");
    }
}