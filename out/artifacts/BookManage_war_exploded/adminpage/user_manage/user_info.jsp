<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Niuniu
  Date: 2020/12/17
  Time: 18:37
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
        <%
            User user=(User)request.getAttribute("user");
        %>
        <form action="/UpdateUserServlet" method="post">
            学号：<input type="text" name="uno" value=<%=user.getUno()%> readonly="readonly"><br>
            姓名：<input type="text" name="uname" value=<%=user.getUname()%>><br>
            密码：<input type="text" name="upasswd" value=<%=user.getUpasswd()%>><br>
            性别：<%=user.getUsex()%><span color="#333">若要修改请直接点一下单选框</span>
            <input type="radio" name="usex" value="男">男
            <input type="radio" name="usex" value="女">女<br>
            年级：<input type="number" name="ugrade" value=<%=user.getUgrade()%>><br>
            <input type="submit" value="修改">
        </form>
    </div>
    <%@ include file="/part/footer.jsp"%>
</div>
</body>
</html>
