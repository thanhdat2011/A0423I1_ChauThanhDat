package com.example.product_discount_calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(urlPatterns = "/display-discount", name = "productDiscountCal")
public class productDiscountCal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double listPrice = Double.parseDouble(req.getParameter("listPrice"));
        double discountPercent = Double.parseDouble(req.getParameter("discountPercent"));
        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<h1>Product Detail<h1>");
        out.println("<h2>Description : " + req.getParameter("description") + "<h2>");
        out.println("<h2>List Price : " + req.getParameter("listPrice") + "<h2>");
        out.println("<h2>DiscountPercent : " + req.getParameter("discountPercent") + "<h2>");
        out.println("<h2>Discount Amount : " + discountAmount + "<h2>");
        out.println("<h2>Discount Price : " + discountPrice + "<h2>");
        out.println("<html>");
    }
}
