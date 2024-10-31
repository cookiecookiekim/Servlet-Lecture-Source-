package com.ohgiraffers.lifecycle.annotation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
// 24-10-31 (목) 2교시 annotation 방식

@WebServlet(value = "/annotation-lifecycle") // 서블릿이란 걸 알려주기 (@)
public class LifeCycleTestServlet extends HttpServlet { //이 클래스가 servlet이라고 알려주기

    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    public LifeCycleTestServlet (){
        System.out.println("annotation 기본 생성자 호출됨.");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("annotation 방식 init() 호출 : " + initCount++);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("annotation 방식 service() 호출 : " + serviceCount++);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("annotation 방식 destroy() 호출 : " + destroyCount++);
    }
}
