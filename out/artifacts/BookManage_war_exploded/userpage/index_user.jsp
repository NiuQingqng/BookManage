<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Niuniu
  Date: 2020/11/29
  Time: 9:54
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
            User user=new User();
            user=(User)session.getAttribute("user");
            if (user==null){
                response.sendRedirect("/login_user.jsp");
            }else{%>
        欢迎你:<a href="/userpage/userinfo.jsp"><%=user.getUname() %></a><br>
            <a href="/userpage/borr_book.jsp">借阅图书</a><br>
            <a href="/userpage/borr_list.jsp">已借图书</a><br>
            <a href="/userpage/borr_history.jsp">借阅历史</a><br>
            <a href="/userpage/userinfo.jsp">查看资料</a><br>
            <a href="/userpage/update_passwd.jsp">修改密码</a><br>
            <a href="/tip.jsp">退出系统</a>
        <%
            }
        %>
    </div>
    <%@ include file="/part/footer.jsp"%>
</div>
</body>
</html>
