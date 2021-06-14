<%--
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
        <form action="/AddUserServlet" method="post">
            学号：<input type="text" name="uno"><br>
            姓名：<input type="text" name="uname" value="牛牛"><br>
            初始密码：<input type="text" name="upasswd" value="123456"><br>
            性别：<input type="radio" name="usex" value="男">男
                <input type="radio" name="usex" value="女">女<br>
            级别：<input type="number" name="ugrade" value="2020"><br>
            <input type="submit">

        </form>
    </div>
    <%@ include file="/part/footer.jsp"%>
</div>
</body>
</html>
