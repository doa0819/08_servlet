package com.ohgiraffers.section01.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/headers")
public class RequestHeaderPrintServlet  extends HttpServlet {

    /* 필기.
    *   헤더란? (=> 인코딩설정, 주요한 정보들을 담고 있는 역할)
    *   우리가 데이터를 전송할 떄 이게 무슨 데이터야. 라고 알려주는 역할이다.
    *   1. General Header - 요청과 응답 모두 적용되는 헤더, 상태 메세지를 나타낸다.(status code: 200 OK -> 오류발생 없이 응답)(★)
    *   2. Request Header - 조회 될 리소스(정보)나 클라이언트 자체에 대한 상세 정보를 포함(★)
    *   3. Response Header - 응답에 대한 부가적인 정보를 갖고 있는 헤더(★)
    *   4. Entity Header - 컨텐츠 길이, MIME 타입과 같은 바디에 대한 상세 정보를 포함한다.(MIME -> html 문서 같은 느낌)
    *   */
    // Request header!!!
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames(); //requestHeaderNames 의 모든 정보를 가지고 온다.(String 으로 지정되어 있다 - 순서대로 줄서 있다)
        while (headerNames.hasMoreElements())  {
            System.out.println(headerNames.nextElement());
        } //headerNames-> 다음요소가 존재하니 물어보는거(true, false), getHeaderNames -> 모든것들 다 꺼내온것

        // accept header : 클라이언트에서 웹서버로 request 할 시 요청할 수 있는 메세지에 담기는 헤더
        // => 나는 출력된 값들만 accept 즉 수용할 수 있어 라는 것과 같음 - accept 안에 json 이라는게 들어있으면  -> 나는 json 파일을 받을거야 라는 의미
        System.out.println("accept : " + req.getHeader("accept"));   //getHeader -> 해당 header만 꺼내옴

        System.out.println("cookie : " + req.getHeader("cookie"));
        // 아이디 별로 다 다르다

    }
}
