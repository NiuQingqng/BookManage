<%@ page import="service.BookService" %>
<%@ page import="entity.Book" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Niuniu
  Date: 2020/12/18
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="styleSheet"  href="/css/content.css" />
</head>
<body>
<%
    ArrayList<Book> books = (ArrayList<Book>)request.getAttribute("books");
%>
<div class="html_main">
    <%@ include file="part/header.jsp"%>
    <div class="content">
        <form action="/SearchBookServlet" method="post">
            <input type="text" name="word">
            <input type="submit" value="查找">
        </form>
        <table>
            <caption>查询结果</caption>
            <tr>
                <td>书号</td>
                <td>书名</td>
                <td>分类</td>
                <td>作者</td>
                <td>状态</td>
                <td>所在位置</td>
            </tr>
            <%
                for(int i=0;i<books.size();i++){
            %>
            <tr>
                <td><%out.print(books.get(i).getBno());%></td>
                <td><%out.print(books.get(i).getBname());%></td>
                <td><%out.print(books.get(i).getCno());%></td>
                <td><%out.print(books.get(i).getBautuor());%></td>
                <td><%out.print(books.get(i).getBstatus());%></td>
                <td><%out.print(books.get(i).getBlocaltion());%></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>

    <%@ include file="part/footer.jsp"%>
</div>
</body>
</html>
