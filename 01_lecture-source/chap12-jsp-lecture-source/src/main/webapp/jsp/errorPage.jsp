<%--isErrorPage="true" 자신이 에러페이지 라는걸 인지 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String exceptionType = exception.getClass().getName();
        String exceptionMessage = exception.getMessage();
    %>

    <h1><%= exceptionType%></h1>
    <hr>
    <h1><%= exceptionMessage%></h1>
</body>
</html>
