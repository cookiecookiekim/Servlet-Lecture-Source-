package com.ohgiraffers.cookie;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// 24-11-01 (금) 5교시, cookie
@WebServlet(value = "/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // (테스트)① 파라미터 입력값 꺼내주기 (사용자 입력값 꺼내주기)
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);
            // 입력값에 따라 잘 출력됨

        // (테스트)② 다른 서블릿에게 처리해 달라고 요청 보내기
//         cookie 사용 전 redirect 구문
//         resp.sendRedirect("redirect"); // "redirect"로 설정
//                                         servlet(클래스) 생성

        /* ↑↑↑↑↑↑ 여기선 출력 되지만 RedirectServlet으로 보내고
           거기선 null이 뜬다 → 데이터가 초기화 됐다는 뜻 ↑↑↑↑↑↑↑↑↑↑↑↑
           → 쿠키 설정이 필요하다 !!!       */

        // ------------------------------------------------------------//
        /* comment. 쿠키 사용 방법
        *   1. 쿠키를 만든다
        *   2. 만든 쿠키의 만료 시간을 설정한다.
        *   3. 응답 헤더에 쿠키를 담는다.
        *   4. 응답을 보낸다. */

        // 1. 쿠키 생성 (key, value)
        Cookie firstNameCookie = new Cookie("firstName" , firstName);
        Cookie lastNameCookie = new Cookie("lastName" , lastName);

        // 2. 쿠키 만료시간 설정
        firstNameCookie.setMaxAge(60 * 60 * 24); // 초 단위 설정 (하루)
        lastNameCookie.setMaxAge(60 * 60 * 24); // 초 단위 설정 (하루)

        // 3. 응답 헤더에 쿠키 담기
         resp.addCookie(firstNameCookie);
         resp.addCookie(lastNameCookie);

         // 4. 이제 리다이렉트 실행하기
        resp.sendRedirect("redirect");
    }
}