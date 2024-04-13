package com.example.servlet;

import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {

    final private String REDIRECT_URL = "users.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("users", Warehouse.getInstance().getUsers());
        req.getRequestDispatcher(REDIRECT_URL).forward(req, resp);
    }
}
