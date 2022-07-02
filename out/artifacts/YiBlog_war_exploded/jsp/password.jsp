<%--
  Created by IntelliJ IDEA.
  User: louis
  Date: 2022/7/2
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<h1>修改密码</h1>

<form action="/user/password" method="post">
    账号: <input type="text" name="uname" value="${user.uname}" readonly></br>
    新密码: <input type="password" name="upwd">
    <input type="submit" value="修改密码">
</form>
</body>
</html>
