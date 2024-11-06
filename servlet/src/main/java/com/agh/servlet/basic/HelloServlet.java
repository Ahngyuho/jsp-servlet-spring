package com.agh.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "helloServlet" , urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Servlet!!");
        System.out.println("HttpServletRequest : " + req);
        System.out.println("HttpServletResponse : " + resp);

        String name = req.getParameter("name");

        System.out.println("userName is " + name);

        resp.setContentType("text/plain");
        resp.getWriter().write("hello " + name);
    }
}
