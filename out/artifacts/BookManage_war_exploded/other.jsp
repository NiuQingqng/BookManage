<%--
  Created by IntelliJ IDEA.
  User: Niuniu
  Date: 2020/11/30
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="styleSheet"  href="css/content.css" />
</head>
<body>
<div class="html_main">
    <%@ include file="part/header.jsp"%>
    <div class="content">
        <%
            String s=request.getParameter("id");
            out.print(s);
        %>
    </div>
    <%@ include file="part/footer.jsp"%>
</div>
</body>
</html>
