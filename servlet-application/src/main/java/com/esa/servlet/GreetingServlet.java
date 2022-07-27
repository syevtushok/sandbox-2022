package com.esa.servlet;

import java.io.IOException;
import java.util.Optional;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
    /**
     * @param req
     * @param resp
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = Optional.ofNullable(req.getParameter("name")).orElse("stranger");
        resp.getWriter().println("Hello " + name);
    }
}
