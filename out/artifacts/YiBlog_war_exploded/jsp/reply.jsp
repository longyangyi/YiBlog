<%--
  Created by IntelliJ IDEA.
  User: louis
  Date: 2022/7/2
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>回复</title>
</head>
<body>
<h1>我的昵称：${user.nickname}</h1>
<h1>我的账号：${user.uname}</h1>

<h1>${blog.senderNickname}：${blog.content}</h1>

${blog.time}

<form action="/blog/reply" method="post">
    <h2>回复@${blog.senderNickname}</h2>
    <input type="text" name="id" value="${blog.id}" hidden>
    <textarea cols="30" rows="3" name="content"></textarea><br>
    <input type="submit" value="回复">
</form>

</body>
</html>
