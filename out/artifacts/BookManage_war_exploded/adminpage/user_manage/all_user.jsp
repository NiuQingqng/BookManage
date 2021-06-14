<%@ page import="entity.User" %>
<%@ page import="java.util.ArrayList" %><%--
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
        <table>
            <caption>所有用户</caption>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>年级</td>
                <td>操作</td>
            </tr>
            <%
                ArrayList<User> users=(ArrayList<User>)request.getAttribute("users");
                for(int i=0;i<users.size();i++){
            %>
            <tr>
                <td><a href="/QueryUserByUnoServlet?uno=<%=users.get(i).getUno()%>"><%=users.get(i).getUno()%></a></td>
                <td><%out.print(users.get(i).getUname());%></td>
                <td><%out.print(users.get(i).getUsex());%></td>
                <td><%out.print(users.get(i).getUgrade());%></td>
                <td><a href="/DelectUserServlet?uno=<%=users.get(i).getUno()%>">删除</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="/adminpage/user_manage/add_user.jsp">添加</a>
    </div>
    <%@ include file="/part/footer.jsp"%>
</div>
</body>
</html>
