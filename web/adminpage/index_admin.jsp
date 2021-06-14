<%--
  Created by IntelliJ IDEA.
  User: Niuniu
  Date: 2020/12/6
  Time: 19:01
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
    <a href="/QueryAllBookServlet">管理图书信息</a><br>
    <a href="/QueryAllUserServlet">管理读者信息</a><br>
    <a href="/QueryAllBorrowServlet">查看读者借阅信息</a><br>
    <a href="/adminpage/admin_update_passwd.jsp">修改密码</a><br>
    <a href="/tip.jsp">退出登录</a>
    </div>
    <%@ include file="/part/footer.jsp"%>
</div>
</body>
</html>
