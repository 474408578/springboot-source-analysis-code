package com.kancloud.springboot.lifecycle.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xschen
 */

@WebServlet(name = "firstServlet", urlPatterns = "/firstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("firstServlet");
    }
}
