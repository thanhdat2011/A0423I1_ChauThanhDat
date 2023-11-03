package com.example.calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calculate", name = "calculateController")
public class calculateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double firstOp = Double.parseDouble(req.getParameter("firstOp"));
        String operator = req.getParameter("operator");
        double secondOp = Double.parseDouble(req.getParameter("secondOp"));
        try {
            double res = calculate(firstOp, operator, secondOp);
            req.setAttribute("res", res);
            req.getRequestDispatcher("calculators/result.jsp").forward(req,resp);
        }
        catch (ArithmeticException e) {
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<p>" + e.getMessage() + "<p>");
            out.println("<html>");
        }

    }

    private static double calculate(Double firstOp, String operator, Double secondOp) throws ArithmeticException {
        double res = 0.0;
        switch (operator) {
            case "addition" :
                res = firstOp + secondOp;
                break;
            case "subtraction" :
                res = firstOp - secondOp;
                break;
            case "multiple" :
                res = firstOp *  secondOp;
                break;
            case "division" :
                if (secondOp == 0) throw new ArithmeticException("Can not divide by 0");
                res = firstOp/secondOp;
                break;
        }
        return res;
    }
}
