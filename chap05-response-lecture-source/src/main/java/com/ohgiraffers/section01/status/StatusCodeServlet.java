package com.ohgiraffers.section01.status;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 24-10-31 (목) 6교시
// 에러 페이지 보여주기
@WebServlet("/status")
public class StatusCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendError(404, "이 페이지는 없습니다 ^ㅅ^");
        resp.sendError(500, "개발자의 잘못으로 인한 서버 내부 오류 발생.");

    }
}
