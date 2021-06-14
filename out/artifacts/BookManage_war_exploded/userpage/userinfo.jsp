<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Niuniu
  Date: 2020/11/29
  Time: 10:52
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
<%
    User user=new User();
    user=(User)session.getAttribute("user");
    if (user==null) {
        response.sendRedirect("/login_user.jsp");
    }else{%>
    <%@ include file="/part/header.jsp"%>
    <div class="content">
        学号：<%=user.getUno() %><br>
        姓名：<%=user.getUname() %><br>
        性别：<%=user.getUsex() %><br>
        年级：<%=user.getUgrade() %><br>
        密码：<a href="/userpage/update_passwd.jsp">修改密码</a><br>
        注：个人信息有错请联系管理员
    </div>
    <%@ include file="/part/footer.jsp"%>
<%
    }
%>
</div>
</body>
</html>
