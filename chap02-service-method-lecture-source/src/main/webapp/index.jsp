<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
    <h1 align="center">Service() 메서드의 역할</h1>
    <h3>GET 방식의 요청</h3> <!-- url에 정보 다 표기 -->
    <h4>a 태그의 href 속성을 통한 GET 요청</h4>
    <a href="request-service">서비스 메서드 요청하기</a>
    <!-- run 이후 해당 서버 1클릭 당 1 request(요청)을 보냈다는 뜻 -->

    <h4>form 태그의 method 속성을 GET으로 설정</h4>
    <form action="request-service" method="get">
        <input type="submit" value="GET 방식 요청 전송">
    </form>

    <h4>form 태그의 method 속성을 POST로 설정</h4>
    <form action="request-service" method="post">
        <input type="submit" value="POST 방식 요청 전송">
    </form>
</body>
</html>