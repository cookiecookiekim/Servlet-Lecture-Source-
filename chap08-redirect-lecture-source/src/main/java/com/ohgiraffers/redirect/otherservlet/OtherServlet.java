package com.ohgiraffers.redirect.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 24-11-01 (금) 2교시 리다이렉트
// otherservlet

@WebServlet(value="/otherservlet")
public class OtherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("GET 요청 정상 수락");

        // 비즈니스 로직 수행 구역 (예시 든 것)
        Logic logic = new Logic(); // Logic 클래스 생성
        logic.registData();

        // 쿼리 스트링으로 값 보내보기 (필수 아님)
        resp.sendRedirect("redirect?name=cho&age=20");
                        //redirect 처리할 서블릿 생성(RedirectServlet)
    }
}
