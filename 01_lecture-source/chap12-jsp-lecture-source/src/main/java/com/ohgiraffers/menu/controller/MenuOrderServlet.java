package com.ohgiraffers.menu.controller;

import com.ohgiraffers.menu.model.service.MenuPriceCalculator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/menu/order")
public class MenuOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        /* 필기.
        *   서블릿의 역할
        *   1. 요청 받은 값 확인 및 검증
        *   2. 비즈니스 로직 처리 (로지처리 -> 계산할게 있으면 계산해준다)
        *   3. 응답 페이지 생성 후 응답 -> jsp 위임
        * */

        //  1. 요청 받은 값 확인 및 검증
        String menuName = req.getParameter("menuName");
        int amount = Integer.parseInt(req.getParameter("amount"));

        System.out.println("menuName = " + menuName);
        System.out.println("amount = " + amount);

        // 2. 비즈니스 로직  -> menuName+amount 보내서 두개 합해서 나오게 할 것
        // menuName, amount 를 넘겨서 우리가 선택 메뉴와 갯수 에 대한 총 가격을 반환
        int orderPrice = new MenuPriceCalculator().calcOrderPrice(menuName, amount);

        req.setAttribute("menuName", menuName);
        req.setAttribute("amount", amount);
        req.setAttribute("orderPrice", orderPrice);

        RequestDispatcher rd = req.getRequestDispatcher("/jsp/5_response.jsp");
        rd.forward(req,resp);

    }
}

// 포워드 : 새로고침했을때 정보가 다 들어간다 => 단순한 검색,조회(DB에서)=> 데이터 쭉 가지고 있따
// 리다이렉트 : 데이터베이스에 영향이 가는 작업 ex) 아이디, 비번.... => 데이터를 쭉 가지고 있지 않다