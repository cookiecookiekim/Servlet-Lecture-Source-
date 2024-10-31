package com.ohgiraffers.service;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
// 24-10-31 (목) 3교시, 서비스
@WebServlet(value = "/request-service") // index.jsp 에서 작성했던 url 입력
public class ServiceMethodServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req; // 요청 변수 생성 (타입 맞게 형변환)
        HttpServletResponse response = (HttpServletResponse) res; // 응답 변수 생성 (타입 맞게 형변환)

        String httpMethod = request.getMethod(); // request.getMethod();은 String 타입이므로 맞게 변수 생성

        System.out.println("httpMethod = " + httpMethod);
        // → request를 통한 요청은 GET 방식.

        if (("GET").equals(httpMethod)){
            // httpMethod 방식이 GET이면
            doGet(request,response);
        } else if(("POST").equals(httpMethod)){
            doPost(request,response);
        }

        /* comment. http 메서드는 get, post, head, options, put, delete 등등이 있지만
        *   가장 많이 사용되는 것은 get과 post 이다. */
    }

    @Override // get만 잡겠다.
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메서드 호출됨...");
    }

    @Override // post만 잡겠다.
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메서드 호출됨...");
    }
}