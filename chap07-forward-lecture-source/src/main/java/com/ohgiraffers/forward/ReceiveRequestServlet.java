package com.ohgiraffers.forward;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/* comment. value 속성
*   @WebServlet 속성이 하나일 때만 생략 가능 */
@WebServlet(value = "/forward") // form 태그의 action과 맞춰주기

// 24-11-01 (금) 1교시, forward
// 사용자의 요청을 받는 서블릿 생성
public class ReceiveRequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청 수락됨...");

    // 사용자의 아이디와 비밀번호 정보 : req에 담겨 있음 → 꺼내주기
        String id = req.getParameter("userId"); // index.jsp
        String pwd = req.getParameter("userPwd"); // index.jsp
        // 잘 출력 되는지 확인 문구
        System.out.println("id = " + id);
        System.out.println("pwd = " + pwd);


        /* 데이터 베이스 관련 비즈니스 로직 작성 공간 */
        // 이건 나중에 학습


        // DB 거쳐 왔다는 가정 하에 사용자에게 어떤 화면을 보여줄지 결정
        // 이 서블릿은 해야할 일이 많기 때문에 응답을 잘하는 서블릿에게 위임.

        // 값을 집어 넣기
        // (key , value 형식)으로 위임 대상 서블릿에게 필요 값 제공
        // key값은 직접 설정
        req.setAttribute("id", id);

        // 요청 다시 보낼 수 있게 할 수 있음.
        // 화면 뿌려줄(위임 받을 곳의) key를 "response" 라고 임의 설정
        RequestDispatcher rd = req.getRequestDispatcher("response");
        // rd를 위임하겠다.(req전달 , response도 직접 하게 resp도 전달)

        rd.forward(req,resp);
    // 실제 화면 동작은 위임받은 서블릿이 하겠지만
    // 위 구문으로 여기 서블릿이 한 것처럼 출력

    }
}