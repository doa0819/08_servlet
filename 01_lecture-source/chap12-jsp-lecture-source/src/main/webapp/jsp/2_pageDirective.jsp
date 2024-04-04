<%@ page import="java.util.Date" errorPage ="errorPage.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <%-- 에러 핸들링--%>
    <%
        Date date = new Date();
        System.out.println("date = " + date);

        String str = null;
        char ch = str.charAt(0);  // NullPointerException 고의 발생
    %>
</body>
</html>
