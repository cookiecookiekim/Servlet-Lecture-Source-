package com.ohgiraffers.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// 24-11-04 (월) 1교시 Session
@WebServlet(value = "/session")
public class SessionHandlingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("userId"); // ① 값 꺼내기
        String pwd = req.getParameter("userPwd");
        System.out.println("id = " + id);
        System.out.println("pwd = " + pwd); // 확인용

        /* comment. redirect 했을 때, id, pwd가 null이 나오는 이유
        *   request 객체가 전혀 다른 객체이기 때문. */

//        resp.sendRedirect("redirect"); // ② 응답 위임하기(재요청)
        // 리다이렉트 서블릿 생성 고고
        // 아래에 세션 생성 후 redirect 하기 위해 주석 처리

        /* comment. 저번에는 Cookie라는 기술로 redirect 시 값 저장하여 사용
        *   하지만 쿠키는 보안상 단점과 지원하지 않는 브라우저 등 문제로
        *   적합하지 않는 경우가 다수 존재함.
        *   예를들어 회원 정보를 이용하여 해당 회원의 로그인 상태를
        *   유지해야 하는 경우가 특히 그렇다.
        *   이번 시간에는 서버쪽에서 관리하는 Session 인스턴스를
        *   사용하여 상태를 유지하는 방법 알아볼 예정*/

        // HttpSession은 인터페이스이므로
        // req.getSession()을 이용하여 객체를 생성할 수 있음.
        HttpSession session = req.getSession();

        // 세션은 만료시킬 수 있는 유효시간이 존재
        // 기본 설정 시간 : 30분
        System.out.println("default 유지 시간 : " + session.getMaxInactiveInterval());
        // 1800 출력

        session.setMaxInactiveInterval(60 * 10); // set 메서드를 통해 10분으로 설정해보기
        System.out.println("변경 후, 유지 시간 : " + session.getMaxInactiveInterval());
        // 600 출력

        /* comment. session의 Id 확인하기
            session은 브라우저당 한 개 씩 고유한 아이디를 가지고 하나의 인스턴스 사용 */
        System.out.println("session의 id : " + session.getId());

        /* comment. session에 값 담는 방법
             : setAttribute(String key , Object value);
                    session에 값 꺼내는 방법
             : getAttribute(key); */
        session.setAttribute("id", id);
        session.setAttribute("pwd", pwd);

        // 값 담아놨으니까 다시 redirect 하기
        resp.sendRedirect("redirect");

    }
}
