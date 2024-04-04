<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 style="text-align: center; color: aquamarine">로그인 창 입니다</h1>
    <form action="/login" method="post">
        <label>아이디 : </label>
        <input type="text" name="userId">
        <br>
        <label>비밀번호 : </label>
        <input type="password" name="password">
        <br>
        <button type="submit">로그인</button>
    </form>

</body>
</html>
