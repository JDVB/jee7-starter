package be.ticket.web;


import be.ticket.dao.PassengerDao;
import be.ticket.entity.Passenger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @EJB
    private PassengerDao dao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Passenger passenger = dao.find(1);
        req.setAttribute("myPassenger", passenger);
        // /......

        req.getRequestDispatcher("/hello.jsp").forward(req, resp);

    }
}