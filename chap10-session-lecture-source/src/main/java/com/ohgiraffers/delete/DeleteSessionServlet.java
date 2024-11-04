package com.ohgiraffers.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// 24-11-04 (월) 2교시 delete
@WebServlet("/delete")
public class DeleteSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* session이 <form action="session">과 같이 연결돼있는
         서블릿에만 영향을 주는줄 알았으나, 그렇지 않다! ↓ 확인하기 ↓ */

        // session 생성하기 (index.jsp에 delete와 연결)
        HttpSession session = req.getSession();

        /* comment. ☆★ 이해하기 ☆★
         *   session 패키지에서 했던 id 값이 그대로 들어있는 것 확인
         *   따라서 session이라는 것은 server가 run하게 되면,
         *   별도의 공간을 할당 받아, 언제든 server가 종료되지 않는다면
         *   값을 꺼내어 사용할 수 있다.
         *   영역 별 비교 : App > Session > request */

        String id = (String) session.getAttribute("id");
        System.out.println("id = " + id);
        // SessionHandlingServlet에서 담아둔 session 데이터가 출력됨.

        System.out.println("==== session 데이터 지워 보기 ① ======");

        /* comment. Session에 들어있는 데이터 지우기
        *   1. 설정 시간 지나면 만료
        *   2. removeAttribute(key)로 session 값 지우기
        *   3. invalidate() 호출 시 session의 모든 데이터 삭제 */

        session.removeAttribute("id");
        String userId = (String) session.getAttribute("id");
        System.out.println("(세션 지우기) userId = " + userId); // null
        // session 데이터 지워진 것 확인

        System.out.println("==== session 데이터 지워 보기 ② ======");
        /* comment.
        *   invalidate 호출 시, 세션 자체를 무효화 함. */
        session.invalidate();
        String password = (String) session.getAttribute("pwd");
        /* comment.
        *   Error 발생 이유는 invalidate()를 통해 Session 자체를 무효화(만료)
        *   시켰기 때문에 이후에 세션 참조 시 에러 발생 */
        System.out.println("(세션 지우기) password = " + password); // 에러 발생
        // HTTP 상태 500 - 내부 서버 오류 발생 (이미 없는 세션)

    }
}
