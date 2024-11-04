package com.ohgiraffers.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    // redirect는 url을 새롭게 변경하기 때문에
    // url과 관련된 doGet 메서드 오버라이딩 해야 함.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("userId");
        String pwd = req.getParameter("userPwd");
        System.out.println("redirect 후 id = " + id);  // ③ 가져온 거 출력해보기
        System.out.println("redirect 후 pwd = " + pwd); // 당연히 null 출력

        System.out.println("↑ 세션 생성 전 ========== ↓ 세션 생성 후");

        HttpSession session = req.getSession(); // 세선 객체 생성
        System.out.println("redirect 페이지의 session id : " + session.getId());
        // SessionHandlingServlet의 생성한 session의 id 값과 동일함
        // → redirect 시, 동일한 값 가지고 있다.

    }
}
