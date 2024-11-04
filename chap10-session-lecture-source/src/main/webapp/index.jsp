<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Session</title>
</head> <!-- 24-11-04 (월) 1교시, Session -->
<body>
    <h1>Session Handling</h1>
    <form action="session" method="post">
        <label>아이디 : </label>
        <input type="text" name="userId">
        <br>
        <label>비밀번호 : </label>
        <input type="password" name="userPwd" placeholder="비밀번호">
        <br>
        <button type="submit">로그인</button>
    </form>
</body>
</html>