<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>博客</title>
</head>
<body>
<h1>我的昵称：${user.nickname}</h1>
<h1>我的账号：${user.uname}</h1>

<form>
    <a href="/user/topassword">修改密码</a>
</form>

<form action="/blog/add" method="post">
<%--    内容: <input type="text" name="content"></br>--%>
    <h2>写博客：</h2>
    <textarea cols="30" rows="3" name="content"></textarea><br>
    <input type="submit" value="发布">
</form>

<h1>博客</h1>
<%--${blogs}--%>
<table>
    <tbody>
    <tr>
        <th>昵称</th>
        <th>内容</th>
        <th>时间</th>
        <th>操作</th>
    </tr>
    <C:forEach items="${blogs}" var="blog">
        <tr>
            <td>${blog.senderNickname}</td>
            <td>
                <C:if test="${blog.receiverNickname != null}">
                    @${blog.receiverNickname}：
                </C:if>
                    ${blog.content}</td>
            <td>${blog.time}</td>
            <td>
                <a href="/blog/toreply?id=${blog.id}">回复</a>
                <C:if test="${blog.senderid == user.id}">
                    <a href="/blog/delete?id=${blog.id}">删除</a>
                </C:if>
            </td>
        </tr>
    </C:forEach>
    </tbody>
</table>
</body>
</html>
