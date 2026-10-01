package com.functionhall.controller;

import com.functionhall.dao.UserDAO;
import com.functionhall.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final UserDAO userDAO = new UserDAO();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u = new User(0, req.getParameter("name"), req.getParameter("email"),
                req.getParameter("password"), "USER");
        if (userDAO.register(u)) resp.sendRedirect("login.html?registered=1");
        else resp.sendRedirect("register.html?error=1");
    }
}