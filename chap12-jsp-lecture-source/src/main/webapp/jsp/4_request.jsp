<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-11-04
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head> <!-- 24-11-04 (월) 5교시 -->
<body>
    <h1>메뉴판</h1>
    <form action="/menu/order" method="post"> <!-- 맨 앞에 / 입력 : 절대경로 -->
<!-- 앞에 / (ex)menu/order 붙이지 않는다면 상대경로라는 뜻
    : 다른 서블릿 넘어갈 때 url이 뒤에 붙게 되어 경로를 찾을 수 없게 됨.
    ex) jsp/menu/order  → jsp가 앞에 붙게 됨-->
        <!-- /menu/order와 같이 앞에 /를 붙이고 url 확인 해보면
         앞의 경로는 무시하고 menu/order만 표시됨 -->

      <select name="menuName" id="menu">
        <option value="햄버거">햄버거</option>
        <option value="짜장면">짜장면</option>
        <option value="불고기백반">불고기백반</option>
        <option value="순댓국">순댓국</option>
      </select>

      <input type="number" min="0" max="50" step="1" name="amount"> <!--속성 설정-->
      <button type="submit">주문하기</button>
    </form>
</body>
</html>
