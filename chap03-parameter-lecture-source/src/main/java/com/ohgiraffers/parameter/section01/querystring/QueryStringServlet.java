package com.ohgiraffers.parameter.section01.querystring;

// 24-10-31 (목) 4교시

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

// 서블릿이라는 걸 인식시키기 // 값이 하나일 때엔 value 안 써도 됨.
@WebServlet("/querystring") // form action의 주소 입력
public class QueryStringServlet extends HttpServlet {

    @Override // get 방식으로 지정해 놓았으니 doGet 오버라이딩
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet() 호출됨...");
        // 홈페이지에서 GET 요청 버튼 누르면 해당 메서드 호출

        /* comment.
        *   HttpServletRequest 객체를 통해 화면에서 요청한 값을
        *   getParameter() 메서드로 꺼내올 수 있다.
        *   인자로 input 태그에 지정한 name 속성의 값을
        *   getParameter() 메서드에 전달해 주면 된다.*/

        String name = req.getParameter("name");
        // 이름의 "name"을 인자로 전달
        System.out.println("우리가 view에서 입력한 이름 : " + name);
        // 화면에서 데이터 입력 후 GET요청 입력시, 여기서 호출
        // → 최초로 화면에서 값을 받아옴.

        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("나이 : " + age);

        Date birthday = Date.valueOf(req.getParameter("birthday"));
        System.out.println("생일 : " + birthday); // sql로 import

        String gender = req.getParameter("gender");
        System.out.println("성별 : " + gender);

        String national = req.getParameter("national");
        System.out.println("국적 : " + national);

        String[] hobbies = req.getParameterValues("hobbies");
        System.out.println("취미 : ");
        for (String hobby : hobbies){
            System.out.println(hobby);
        }
        // 홈페이지에서 작성 후 GET 요청 입력하니,
        // 여기 콘솔창에 해당 정보 출력
    }
}
