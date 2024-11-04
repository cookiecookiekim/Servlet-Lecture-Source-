<%@ page import="java.time.LocalDateTime" errorPage="errorPage.jsp" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-11-04
  Time: 오후 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head> <!-- 4교시 jsp 이어서,-->
<body>
    <h1>Page 지시자 태그</h1>
    <%
      LocalDateTime date = LocalDateTime.now();
      System.out.println("date = " + date); // 잘 출력

      // 고의로 NullPointException 발생시키기
      String str = null;
      char ch = str.charAt(0); // a 태그 클릭시 오류 페이지 송출
        // 오류 페이지말고 내가 만든 view 페이지 보여주려면 상위에 errorPage 추가
    %>
</body>
</html>
