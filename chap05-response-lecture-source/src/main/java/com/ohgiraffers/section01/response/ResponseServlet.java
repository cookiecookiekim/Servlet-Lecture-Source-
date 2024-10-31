package com.ohgiraffers.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 사용자 입력 값은 request에서 get으로 꺼내옴
        /* comment. 서블릿이 수행하는 역할은 크게 3가지 존재.
        *   1. 사용자의 요청 받기 (request)
        *     - HttpMethod 종류에 따라서 parameter로 넘어온 데이터 꺼내기
        *   2. 입력 받은 값을 토대로 비즈니스 로직 구현
        *     - EX) DB 접속 관련, CRUD 관련 로직
        *   3. 사용자에게 응답(response)하기
        *     - 문자열로 동적인 웹페이지를 만들고 스트림을 이용해 내보냄. */

        String hi = "응답 결과입니다.";
        StringBuilder builder = new StringBuilder();
        // StringBuilder : 기존 문자열에 값 추가할 수 있음
        // (String은 새로운 공간을 만들어서 더했었음)
        builder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h1>" + hi + "</h1>")
                .append("</body>\n")
                .append("</html>");
        // 작성하는데 불편함.

        resp.setContentType("text/html; charset=UFT-8");
        // 이거 없으면 a 홈페이지 클릭 시 , 번역 오류 발생(글자 깨짐)

        PrintWriter out = resp.getWriter();
        out.write(builder.toString()); // 빌더를 문자열로 바꿔서 넘기기

        out.flush(); // 사용한 자원 밀어주기
        out.close(); // 사용한 자원 닫기
    }
}
