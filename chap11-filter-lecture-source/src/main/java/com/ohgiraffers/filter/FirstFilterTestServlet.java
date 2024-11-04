package com.ohgiraffers.filter;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// 24-11-04 (월) 2~3교시 Filter
@WebServlet(value = "/first/filter")
public class FirstFilterTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doGet 메서드 호출 확인됨...");

        // resp.setContentType("text/html; charset=UTF-8"); 일부러 생략
        PrintWriter out = resp.getWriter(); // 뷰페이지 만들기
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head></head>");
        out.println("<body>");
        out.println("<h3>필터 확인용 서블릿 요청 확인</h3>");
        out.println("</body>");
        out.println("</html>");

        out.flush();
        out.close();
        // a 태그 클릭 시 글자 깨져서 출력

        // → filter 클래스(서블릿이 아닌, WebFilter) 생성
    }
}