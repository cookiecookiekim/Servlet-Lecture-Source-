<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-11-04
  Time: 오후 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      Date today = new Date();
      SimpleDateFormat sdf =
              new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
      // 그냥 Date로 출력하면 이상하게(밀리초 등) 출력되는데
      // 원하는 형식으로 바꿔서 출력하기 위해 SimpleDateFormat 함수 사용

      String output = sdf.format(today);
    %>
    <h3 style="color: red"><%=output%>></h3>
</body>
</html>
