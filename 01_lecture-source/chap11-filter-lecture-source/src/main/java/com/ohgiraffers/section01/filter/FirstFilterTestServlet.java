package com.ohgiraffers.section01.filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/first/filter")
public class FirstFilterTestServlet extends HttpServlet {

    // 필터 라이프 사이킄
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doGEt Servlet 요청 확인...");   // 잘 작동되는지 확인 (제일 먼저 작동)

//        resp.setContentType("text/html; charset=UTF-8");   -> encoding 이 꺠지지 않는다

        PrintWriter out = resp.getWriter();
        out.println("<!=doctype html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>필터 확인용 서블릿 요청 확인 완료!!</h3>");
        out.println("</body>");
        out.println("</html>");

        out.flush();
        out.close();



    }
}
