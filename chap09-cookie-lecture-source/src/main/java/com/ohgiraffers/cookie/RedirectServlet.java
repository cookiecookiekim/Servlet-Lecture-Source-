package com.ohgiraffers.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// CookieServlet에게 받은 요청을 처리하기 위한 서블릿
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* comment. 최초, POST인데 doGet 쓰는 이유
        *   Redirect 시에는 URL을 재작성하게 되며,
        *   URL을 통해서 요청하는 방식이기 때문에
        *   POST 방식이 아닌 GET 방식으로 처리해야 한다.
        *   따라서 Redirect 되는 서블릿은 doGet 메서드를
        *   사용하여 처리해야 한다.
        *   → ure이 바뀌니까 get 써야한다. */

        // (테스트)③ 받은 파라미터 꺼내기
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        /* comment.
        *   출력 했을 때, null 나오는 것 확인
        *   따라서 redirect 시에는 request가 2번 이루어지기
        *   떄문에 1번째 request와 2번째 request는
        *   전혀 다른 객체가 된다. → 값 공유 불가능 */

        /* comment. 쿠키 사용하는 방법
         *   1. request에서 쿠키 목록을 배열 형태로 꺼낸다.
         *   2. 쿠키의 getName(), getValue()를 사용하여 꺼낸다. */

        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++){
            System.out.println("cookie : " + cookies[i].getName()
            + "-" + cookies[i].getName());

            if ("firstName".equals(cookies[i].getName())){
                firstName = cookies[i].getValue();
            } else if ("lastName".equals(cookies[i].getName())){
                lastName = cookies[i].getValue();
            }
        }
        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3>")
                .append(firstName)
                .append(lastName)
                .append("님 하위~</h3>")
                .append("</body>\n")
                .append("</html>\n");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(responseText.toString());

        out.flush();
        out.close();
        
        /* comment.
        *   쿠키의 경우 text 파일 형태로 클라이언트 컴퓨터에 저장.
        *   그렇기 때문에 개인 PC는 상관 없지만,
        *   공용 PC의 경우 탈취 위험에 노출됨.
        *   따라서 민감한 정보는 session을 이용하게되며
        *   session은 클라이언트 컴퓨터가 아닌,
        *   서버 컴퓨터(톰켓서버)에 관리 되기 때문에 보안에 우수하다. */
    }
}
