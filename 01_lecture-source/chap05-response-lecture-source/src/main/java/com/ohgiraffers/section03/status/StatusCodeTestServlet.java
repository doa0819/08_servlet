package com.ohgiraffers.section03.status;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/status")
public class StatusCodeTestServlet extends HttpServlet {
    //404(에러코드) -> 페이지 찾을수 없음 => 이곳 수정할 거임~
    // 예외페이지 커스텀 할 수 있다~~(sendError 이용해서)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 강제 예외 상황 발생
//        resp.sendError(404, "페이지가 없어.. 찾아봤는데 없어...");
        // 500 -> 코드오류
        resp.sendError(500, "서버 내부 오류입니다. 서버오류는 오직 개발자의 잘못이며, 개발자는 여러분 입니다.");
    }
}
