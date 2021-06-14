<%@ page import="entity.Book" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Niuniu
  Date: 2020/12/6
  Time: 19:04
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
        <form action="/SearchBookServlet" method="post">
            <input type="text" name="word">
            <input type="submit" value="查找">
        </form>
        <table>
            <caption>所有图书</caption>
            <tr>
                <td>书号</td>
                <td>书名</td>
                <td>分类</td>
                <td>作者</td>
                <td>状态</td>
                <td>所在位置</td>
                <td>操作</td>
            </tr>
            <%
                ArrayList<Book> books=(ArrayList<Book>)request.getAttribute("books");
                for(int i=0;i<books.size();i++){
            %>
            <tr>
                <td><a href="/QueryBookByBnoServlet?bno=<%=books.get(i).getBno()%>"><%=books.get(i).getBno()%></a></td>
                <td><%out.print(books.get(i).getBname());%></td>
                <td><%out.print(books.get(i).getCno());%></td>
                <td><%out.print(books.get(i).getBautuor());%></td>
                <td><%out.print(books.get(i).getBstatus());%></td>
                <td><%out.print(books.get(i).getBlocaltion());%></td>
                <td><a href="/DelectBookServlet?bno=<%=books.get(i).getBno()%>">删除</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="/adminpage/book_manage/add_book.jsp">添加</a>
    </div>
    <%@ include file="/part/footer.jsp"%>
</div>
</body>
</html>
