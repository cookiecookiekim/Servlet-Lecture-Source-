package com.ohgiraffers.jsp.controller;

import com.ohgiraffers.jsp.service.MenuPriceCalculator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 24-11-04 (월) 5교시 4_request를 처리할 서블릿 생성
@WebServlet(value = "/menu/order")
public class MenuOrderServlet extends HttpServlet {
    // 추후 MVC 패턴에서 controller 역할

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // ① 사용자의 요청에 대한 처리
        String menuName = req.getParameter("menuName");
        // select name을 key로 꺼내기
        int amount = Integer.parseInt(req.getParameter("amount"));
        // input name을 key로 꺼내기

        // ② 간단한 비즈니스 로직 수행
        // service 패키지에 MenuPriceCalculator 클래스, 메서드 생성 생성
        int totalPrice = new MenuPriceCalculator().calcTotalPrice(menuName, amount);

        // ③ setAttribute를 통해 key와 value 설정
        // → 다른 서블릿에서 사용할 값 setting
        req.setAttribute("menuName", menuName);
        req.setAttribute("amount", amount);
        req.setAttribute("totalPrice", totalPrice);

        // ④ forward로 해보기
        // → "/jsp/5_response.jsp" 파일로 forward 시키겠다.
        // "/jsp/5_response.jsp" 파일 생성
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/5_response.jsp");
        rd.forward(req,resp);
    }
}
