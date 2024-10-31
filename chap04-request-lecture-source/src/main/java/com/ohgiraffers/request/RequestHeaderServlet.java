package com.ohgiraffers.request;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/headers")
public class RequestHeaderServlet extends HttpServlet {
    // a 태크(링크로 접근) : get 방식

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerName = req.getHeaderNames();
        while(headerName.hasMoreElements()){
            System.out.println(headerName.nextElement()); // 요소 출력
            // 여기서 출력 결과와 페이지 상의 headers 요소 비교해보기
        }
    }
}