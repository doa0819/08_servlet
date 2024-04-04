package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    // dopost 가 아닌이유 : url 로 보낼거기 때문에 doget 사용!!!!!!!
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        /* 필기.
        *   null
        *   왜냐? request 객체는 1회 요청 시 하나의 객체를 만들게 되는데
        *   2번의 요청이 일어나고 있기 떄문에 값을 공유할 수 없다.(재요청 불가)
        * */

        /* 필기.
        *   쿠키를 사용하는 방법
        *   1. request 에서 쿠키 목록을 배열 형태로 꺼내온다.
        *   2. 쿠키의 getName 과 getValue 를 이용해 쿠키에 담긴 값을 꺼낸다.
        * */

        Cookie[] cookies = req.getCookies();

        for (int i = 0; i < cookies.length; i++){
            System.out.println("[cookie]" + cookies[i].getName() + " : " + cookies[i].getValue());

            if ("firstName".equals(cookies[i].getName())){
                firstName = cookies[i].getValue();
            }else if ("lastName".equals(cookies[i].getName())){
                lastName = cookies[i].getValue();
            }
        }

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h1> firstName : " + firstName + "</h1>")
                .append("<h1> lastName : " + lastName + "</h1>")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(responseText.toString());

        out.flush();
        out.close();
    }

    /* 필기.
    *   쿠키는 텍스트 파일 형태로 클라이언트 컴퓨터에 저장된다.
    *   그렇기 때문에 개인 pc 라면 상관이 없지만
    *   공용 pc 이면 보안에 좀 많이 취약하다.
    *   세션은 쿠키와 유사한 형태로 key-value 쌍으로
    *   저장 되지만, 서버에서 관리되므로 보안에 우수하다.
    * */
}
