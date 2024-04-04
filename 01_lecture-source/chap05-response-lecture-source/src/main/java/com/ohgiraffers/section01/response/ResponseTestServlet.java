package com.ohgiraffers.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 필기.
        *   서블릿이 수행하는 역할은 크게 3가지 이다.
        *   1. 요청받기 - HttpMethod GET/POST 요청에 따라서 parameter로 전달받은 데이터를 꺼낸다.
        *   2. 비즈니스 로직 처리 - ex) DB 접속과 CRUD 관련된 로직 작성(스프링에서 더 자세히 다룰예정)
        *   3. 응답 하기 - 문자열로 동적인 웹(HTML 태그) 페이지를 만들고 스트림을 이용하여 보낸다.
        * */

        String hi = "안녕 여러분";

        // 문자열로 페이지 만들기
        StringBuilder responseBuilder = new StringBuilder();  //StringBuilder-> 새로운 공간을 만들지 않고 append 이용해서 붙인다

        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h1>" + hi + "</h1>")
                .append("</body>\n")
                .append("</html>\n");

        // 응답할 타입(=content type) 설정(set값 설정)  => 안하면 한글파일 꺠짐~
        resp.setContentType("text/html; charset=UTF-8");

        // 만드거 스트림 이용해서 내보내기
        PrintWriter out = resp.getWriter();
        out.write(responseBuilder.toString());   // out 변수에 write 메소드 호출 // tostring 통해서 나갈 연결통로 만듬

        out.flush();  // 덜 나간 애들이 있는지 한번 밀어줌
        out.close();




    }
}
