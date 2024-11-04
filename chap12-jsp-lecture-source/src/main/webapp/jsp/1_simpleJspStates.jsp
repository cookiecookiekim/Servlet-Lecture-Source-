<!-- 페이지 지지사 태그 (추가적으로 지시자 태그는 include, taglib 등이 있다.) -->

<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-11-04
  Time: 오후 12:04
  To change this template use File | Settings | File Templates.
--%>

<%-- RUN시 화면 담당 --%>
<%-- a 태그 클릭시 기존 서블릿이 보여지는 게 아니라 index.jsp 파일 동작 --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- jsp 파일 생성과 동시에 contentType 자동 입력 --%>
<%-- html 파일 같지만 java 언어로 만들어진 파일 --%>

<html>
<head>
    <title>Title</title>
</head>
<body> <!-- 이 영역은 html 같지만 실제로는 자바 파일 -->
    <h1>JSP 기본 문법</h1>
    <!-- HTML 주석 -->
    <%-- JSP 주석 --%>
    <%-- 개발자 도구 확인 시, 이건 확실한 주석 --%>

    <%-- 아래 영역<%! %>에 변수 생성 가능 --%>
    <%-- 생성과 동시에 초기화 가능하지만 역할 구분용 --%>
    <%!
        private String name;
        private int age;
    %>

    <!-- 스크립트릿 태그 --> <!-- 선언할 변수를 사용할 하나의 영역-->
    <%
        name = "김규남";
        age = 20;

        System.out.println("name = " + name);
        System.out.println("age = " + age);
    %>

    <!-- 표현 태그 -->
    <h3>이름 : <%= name %></h3>
    <h3>나이 : <%= age %></h3>
    <!-- run, a태크 클릭시 해당 내용 출력-->
    <!-- 템플릿 엔진 → _1_005fsimpleJspStates_jsp.class 파일 확인해보면
        위의 값이 삽입돼있음 -->
</body>
</html>
