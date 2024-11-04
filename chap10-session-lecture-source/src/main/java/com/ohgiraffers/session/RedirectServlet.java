package com.ohgiraffers.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

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

        // 2교시, session에 담아 놓은 값 꺼내기
        /* 동일한 ID 를 가지 Session에서는 setAttribute로 넣은 값을
         getAttribute로 꺼낼 수 있음. */
        id = (String) session.getAttribute("id"); // 형변환
        pwd = (String) session.getAttribute("pwd");

        System.out.println("세션 생성 이후 id :  " + id);

        // 출력 해보기
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>");
        out.println(id + "님 환영합니다.");
        out.println("</h3>");
        out.println("</body>");
        out.println("</html>");

        out.flush();
        out.close();
    }
}
