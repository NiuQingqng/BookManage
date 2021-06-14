<%--
  Created by IntelliJ IDEA.
  User: Niuniu
  Date: 2020/12/6
  Time: 20:17
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
        <form action="/AddBookServlet" method="post">
            书号：<input type="text" name="bno"><br>
            书名：<input type="text" name="bname" value="牛牛的书"><br>
            书类：<input type="text" name="cno" value="牛牛的书"><br>
            作者：<input type="text" name="bautuor" value="牛牛"><br>
            出版社:<input type="text" name="bpublisher" value="牛牛的出版社"><br>
            价格：<input type="number" name="bprice" value="52"><br>
            ISBN：<input type="text" name="bISBN" value="10561561"><br>
            所在图书馆位置：<input type="text" name="blocaltion" value="牛牛的书库"><br>
            <input type="submit">

        </form>
    </div>
    <%@ include file="/part/footer.jsp"%>
</div>
</body>
</html>
