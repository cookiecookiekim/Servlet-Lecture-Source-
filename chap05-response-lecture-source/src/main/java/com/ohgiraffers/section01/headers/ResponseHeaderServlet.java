package com.ohgiraffers.section01.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

// 24-10-31 (목) 6교시
@WebServlet("/headers")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        // 개발자 도구에 header : Content-Type 확인하면 동일

        PrintWriter out = resp.getWriter();

        LocalDateTime time = LocalDateTime.now();
        // 날짜 추가

        out.print("<h1>" + time + "</h1>"); // 화면을 그려줘
        // run 시 페이지에 날짜 출력
        out.close();

    }
}
