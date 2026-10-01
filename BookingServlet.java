package com.functionhall.controller;

import com.functionhall.dao.BookingDAO;
import com.functionhall.model.Booking;
import com.functionhall.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
    private final BookingDAO dao = new BookingDAO();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User u=(User)req.getSession().getAttribute("user");
        if(u==null){ resp.sendRedirect("login.html"); return; }
        Booking b=new Booking(0,u.getId(),Integer.parseInt(req.getParameter("hallId")),
                LocalDate.parse(req.getParameter("date")),req.getParameter("event"),
                req.getParameter("payment"),"CONFIRMED");
        if(dao.create(b)) resp.sendRedirect("my-bookings.html?success=1");
        else resp.sendRedirect("booking.html?error=1");
    }
}