package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

    final private String REDIRECT_URL = "add.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(REDIRECT_URL);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        User user = new User(firstName, lastName);
        Warehouse.getInstance().addUser(user);
        req.setAttribute("user", user);
        req.getRequestDispatcher(REDIRECT_URL).forward(req, resp);
    }
}
