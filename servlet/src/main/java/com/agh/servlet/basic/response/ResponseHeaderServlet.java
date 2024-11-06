package com.agh.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status line]
        response.setStatus(HttpServletResponse.SC_OK);

        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
        // 캐시 무효화 설정
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");

        response.setHeader("my-header", "hello");

        content(response);
        cookie(response);
        redirect(response);

        response.getWriter().write("ok");
    }

    private void content(HttpServletResponse response) {
        // 아래 설정 코드 결과
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2

        //이 설정 코드를
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");

        //아래와 같이 변경 가능
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }

    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;

        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie myCookie = new Cookie("my-cookie", "hello");
        myCookie.setMaxAge(600);
        response.addCookie(myCookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html
//        response.setStatus(HttpServletResponse.SC_FOUND);
//        response.setHeader("Location", "/basic/hello-form.html");

        response.sendRedirect("/basic/hello-form.html");
    }

}
