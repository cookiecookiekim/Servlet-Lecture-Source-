package com.ohgiraffers.redirect.othersite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 24-11-01 (금) 2교시 리다이렉트
// 최초 요청 받고, 해당 처리를 못 한다고 response 보내주는 서블릿
// 요청자는 최초 response 받고, nexon으로 재요청 할 것.
@WebServlet(value="/othersite")
public class OtherSiteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청 후 nexon 사이트로 리다이렉트");

        resp.sendRedirect("https://nexon.com");
        // 최초 요청받은 othersite가 nexon.com으로 재요청했음 확인 (network 확인)

    }
}
