package com.example.time_system;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet(urlPatterns = "/time", name = "ServerTimeServlet")
public class ServerTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date today = new Date();
        req.setAttribute("today", today);
        req.getRequestDispatcher("interfaces/times.jsp").forward(req,resp);
    }
}
