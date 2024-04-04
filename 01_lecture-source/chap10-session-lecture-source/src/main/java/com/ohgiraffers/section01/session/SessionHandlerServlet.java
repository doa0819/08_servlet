package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        // session 생성 -> 인터페이스여서 직접적으로 못만듬 (getSession 필요)
        HttpSession session = req.getSession();

        /* session 기본 만료시간(30분(=1800초)이 기본설정 시간)*/
        System.out.println("session 의 기본 만료 시간 : " + session.getMaxInactiveInterval());

        session.setMaxInactiveInterval(60 * 10);   // 10분
        System.out.println("변경 후 session 만료 시간 : " + session.getMaxInactiveInterval());

        // session 은 브라우저 당 한 개씩 고유한 아이디를 가지고 하나의
        // 인터페이스를 이용한다. 매번 반복 시 동일한 session id 를 반환한다.

        System.out.println("session id : " + session.getId());

        /* 필기.
        *   만든 session 에 공유할 값 담기
        *   setAttribute(String key, Object value) 형태로 담는다.
        *   getAttribute(key) => 자동으로 value 값이 꺼내진다.  <- 값을 꺼낼떄
        * */

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        resp.sendRedirect("redirect");


    }
}
