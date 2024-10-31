package com.ohgiraffers.parameter.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// POST DATA를 처리할 클래스 생성
@WebServlet("/formdata") // action 주소 입력
public class FormDataServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("name = " + name);
        // 홈페이지에서 요청 시, 여기에 name 출력
    }
}
