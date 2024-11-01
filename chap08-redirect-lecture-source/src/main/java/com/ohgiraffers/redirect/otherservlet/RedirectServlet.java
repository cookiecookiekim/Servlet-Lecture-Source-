package com.ohgiraffers.redirect.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("이 서블릿으로 Redirect 성공.");

        // 아까 쿼리 스트링으로 넘겼던 값 꺼내기
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        System.out.println("name = " + name); // 확인 출력 문구
        System.out.println("age = " + age); // 확인 출력 문구

        // 화면에 표시할 내용 작성
        StringBuilder redirectText = new StringBuilder();
        redirectText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h1>이 서블릿으로 redirect 성공!</h1>\n")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(redirectText);
        out.flush();
        out.close();

        // 이 방식은 새로고침 할 시 DB에 영향을 주지 않음.
    }
}
