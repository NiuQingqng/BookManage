<%--
  Created by IntelliJ IDEA.
  User: Niuniu
  Date: 2020/12/19
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="styleSheet"  href="/css/content.css" />
</head>
<body>
<div class="html_main">
<%@ include file="/part/header.jsp"%>
<div class="content">
    <form action="/UserUpdatePasswd" method="post">
        旧密码：<input type="password" name="old_passwd"><br>
        新密码：<input type="password" name="new_passwd_1"><br>
        确认密码：<input type="password" name="old_passwd_2"><br>
        <input type="submit" value="提交">
    </form>
</div>
<%@ include file="/part/footer.jsp"%>
</div>
</body>
</html>
