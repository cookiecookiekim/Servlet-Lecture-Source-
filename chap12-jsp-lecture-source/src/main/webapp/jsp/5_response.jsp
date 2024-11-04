<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-11-04
  Time: 오후 3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> <!-- MenuOrderServlet에서 forward로 받은 rd 처리 -->
    <title>Title</title>
</head>
<body>
    <%
      /* comment. 헷갈리지 말아야 할 사항
      *   JSP 파일도 Servlet이다. (JSP 파일 = Servlet)
      *   따라서 request와 response가 존재한다.
      *   - JSP 파일은 response를 더 쉽게 처리하기 위한
      *   view 역할 담당 Servlet 이라고 생각 하자.*/

      // 1. 값 꺼내기
      String menuName = (String) request.getAttribute("menuName");
      int amount = (int) request.getAttribute("amount");
      int totalPrice = (int) request.getAttribute("totalPrice");
    %>
    <table border="1">
      <th>메뉴 이름</th>
      <th>주문 수량</th>
      <th>최종 가격</th>
      <tr>
        <td><%=menuName%></td>
        <td><%=amount%></td>
        <td><%=totalPrice%></td>
      </tr>
    </table>
    <!-- comment. 이렇게 JSP를 사용하게 되면 서블릿 클래스에서
            VIEW를 만드는 것 보다 훨씬 간편하게 만들 수 있다.
            따라서 알 수 있는 것은 jsp는 view에 적합한 서블릿,
            클래스 서블릿은 비즈니스 로직에 적합한 서블릿 이라는 결론
            → spring-mvc model2 구조에서는 서블릿을 controller 계층,
            jsp를 view 계층으로 구현하게 된다. -->
</body>
</html>
