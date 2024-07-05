package com.example.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello", "/hi", "/welcome"})
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/hello":
                req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
                break;
            case "/hi":
                req.getRequestDispatcher("/WEB-INF/jsp/hi.jsp").forward(req, resp);
                break;
            case "/welcome":
                req.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }
}
