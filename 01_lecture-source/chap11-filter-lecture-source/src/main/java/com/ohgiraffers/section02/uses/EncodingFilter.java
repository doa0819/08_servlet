package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/* XMl 방식으로 filter 등록해보기*/ //-> 등록을 해놔서 따로 쓰지 않아도 한글이 깨지지 않는다.

public class EncodingFilter implements Filter {

    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        /* 필기. xml 설정한 init-param 의 key를 이용하여 config 에서 값을 꺼낼 수 있다. */
       encodingType = filterConfig.getInitParameter("encoding-type");   //filterConfig -> 초기설정

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setContentType(encodingType);  // "text/html ~"  미리 가지고 넘겨준다

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {



    }
}
