package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/first/*")  // * -> first 만 있으면 모든 <a> 태그에 있는것들을 다 실행한다. /* => 어떤 변수가 없어도 모든 것을 다 실행 시킨다는 뜻
public class FirstFilter implements Filter {

    // 어노테이션 타입
    // 필터가 먼저 가로채서 자기 할거 다 진행 후 다은으로 넘어감(firstFilterTest class 먼저 진행 후 firstFilter 로 넘어와서 진행 )

    public FirstFilter(){
        System.out.println("FirstFilter 인스턴스 생성됨!!!");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        /* 필기.
        *   init -> 최초
        *   필터의 인스턴스가 최초 생성 될 때 호출되는 메소드
        * */

        System.out.println("Filter init() 호출됨...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /* 필기.
        *   Servlet 으로 request 가 전달되기 전에 요청을 가로채는 메소드
        * */
        System.out.println("Filter doFilter() 호출됨...");

        /* 필기. 필터에서 처리할 코드를 작성한다.*/

        /* 필기. 처리를 한 뒤 다음 필터 혹은 서블릿의 doGet/doPost 를 호출한다.*/
        filterChain.doFilter(servletRequest, servletResponse);
        // 내가 만든 서블릿으로 넘어간다

        /* 필기. 서블릿에서 처리후에 다시 수행할 내용이 있다면 작성하는 공간 */
        System.out.println("Servlet 요청 수행 완료!!");
    }

    @Override
    public void destroy() {

        /* 필기.
        *   destroy -> 파괴함
        *   필터 인스턴스가 소멸될 떄 호출되는 메소드(= 톰켓을 종료할 때)
        * */
        System.out.println("Filter destory() 메소드 호출됨...");

    }
}
