package com.ohgiraffers.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// 24-11-01 (금) 1교시, forward
// 위임 받고, response해주는 클래스 (화면에 뿌려주는)
@WebServlet("/response") // 위임 해준 ReceiveRequestServlet에서 전달받은 "response" 입력
public class ResponseServlet extends HttpServlet {

    @Override // 최초 요청(post)에 대해 doPost 오버라이드
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 꺼낼 때는 get 메서드로 꺼내고 set의 key값 입력
        // type이 맞지 않기 때문에 형변환
        String userId = (String) req.getAttribute("id");
        System.out.println("Request 서블릿에서 전달받은 ID : " + userId);

        // 화면에 표시할 내용 작성
        StringBuilder response = new StringBuilder();
        response.append("<!doctype html>\n");
        response.append("<html>\n");
        response.append("<head></head>\n");
        response.append("<body>\n");
        response.append("<h3 align=\"center\">"); // \" 문자열이 아닌 기호로 표시
        response.append(userId);
        response.append("</h3>");
        response.append("</body>\n");
        response.append("</html>");
        // 이렇게 내보내면 에러 발생, setContenType 설정 해줘야함

        resp.setContentType("text/html;charset=UTF-8"); // html 파일 응답하겠다.
        PrintWriter out = resp.getWriter();
        out.print(response.toString());

        out.flush();
        out.close();

        // 해당 클래스가 실제로 화면을 보여주지만,
        // 출력 후 개발자 도구 확인 시 forward로 떠있는데,(url도 forward)
        // ResponseServlet가 처리했지만,
        // 최초 요청받은 ReceiveRequestServlet가 한 척 했다 라는 뜻.
    }
}
