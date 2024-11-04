package com.ohgiraffers.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/first/*") // ← first로 시작하는 모든 요청을 거르겠다.
/* → /first 요청 들어오면 FirstFilterTestServlet 서블릿 호출 전에
     먼저 이쪽 필터를 거치고 간다는 뜻이다. */

public class FirstFilter implements Filter { // 3가지 오버라이드 해야 오류 안 남

    public FirstFilter(){
        System.out.println("필터 기본 생성자 호출됨..");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter 인스턴스 최초 생성 시 호출됨...");
    }

    @Override
    public void destroy() { // 파괴하는 메서드
        System.out.println("destroy filter 인스턴스 소멸됨..");
    }

    @Override // 핵심 메서드 (필터가 해야할 일 여기에 작성)
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /* comment. doFilter 메서드는 request가 전달되기 전에
        *           이쪽으로 가로채어 무엇인가 할 일 작성 ! */

        System.out.println("doFilter() 호출됨...");

        // 필터에서 실행할 코드 작성 영역

        // 실행 코드 실행 후 다음 필터 혹은 서블릿으로 doGet/doPost 호출
        filterChain.doFilter(servletRequest,servletResponse);
        // filterChain 매개변수에 doFilter 메서드로 req와 resp 전달
        // → 화면 보여줄 서블릿으로 이동

        // 서블릿에서 처리 후 다시 수행할 내용 있으면 작성하는 영역
        System.out.println("Servlet 할 일 종료.");
        // 모든 일 종료 후 해당 문구 마지막에 출력

    }
}
