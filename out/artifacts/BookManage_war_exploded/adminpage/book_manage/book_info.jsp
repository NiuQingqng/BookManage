<%@ page import="entity.Book" %><%--
  Created by IntelliJ IDEA.
  User: Niuniu
  Date: 2020/12/6
  Time: 21:57
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
    Book book=(Book)request.getAttribute("book");
%>
        <form action="/UpdateBookServlet" method="post">
            书号：<input type="text" name="bno" value=<%=book.getBno()%> readonly="readonly"><br>
            书名：<input type="text" name="bname" value=<%=book.getBname()%>><br>
            书类：<input type="text" name="cno" value=<%=book.getCno()%>><br>
            作者：<input type="text" name="bautuor" value=<%=book.getBautuor()%>><br>
            出版社:<input type="text" name="bpublisher" value=<%=book.getBpublisher()%>><br>
            价格：<input type="number" name="bprice" value=<%=book.getBprice()%>><br>
            状态：<input type="text" name="bstatus" value=<%=book.getBstatus()%> ><br>
            ISBN：<input type="text" name="bISBN" value=<%=book.getbISBN()%>><br>
            所在图书馆位置：<input type="text" name="blocaltion" value=<%=book.getBlocaltion()%>><br>
            <input type="submit" value="修改">
        </form>
    </div>
    <%@ include file="/part/footer.jsp"%>
</div>
</body>
</html>
