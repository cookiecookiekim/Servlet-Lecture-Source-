<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-11-04
  Time: 오후 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
  isErrorPage="true" %>
<html>
<head> <!-- 에러 발생했을 때 이용자에게 보여줄 페이지 작성-->
    <title>Title</title>
</head>
<body>
    <%
      // exception이 컴파일 에러가 뜨는데
      // 이유는 exception도 errorPage에 등록 됐는지 모르기 때문이다.
      // 인식 시켜주려면 위에 isErrorPage"true" 추가
      // → exception 관련 정보 사용 가능
      String exceptionType = exception.getClass().getName();
      String exceptionMsg = exception.getMessage();
    %>

    <h1><%=exceptionType%></h1>
    <h3><%=exceptionMsg%></h3>
    <!-- 2번 a태그 클릭 시, 브라우저 에러 페이지가 아닌 직접 커스텀한 에러 페이지 송출 -->
</body>
</html>
