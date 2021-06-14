<%@ page import="entity.Borrow" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Niuniu
  Date: 2020/12/22
  Time: 9:41
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
            <caption>借阅列表</caption>
            <tr>
                <td>记录编号</td>
                <td>学号</td>
                <td>书号</td>
                <td>书名</td>
                <td>借阅时间</td>
                <td>归还时间</td>
                <td>状态</td>
                <td></td>
            </tr>
            <%
                ArrayList<Borrow> borrows=(ArrayList<Borrow>)request.getAttribute("borrows");
                String status="未知";
                for(int i=0;i<borrows.size();i++){
                    if(borrows.get(i).getStatus()==0){
                        status="未还";
                    }else if(borrows.get(i).getStatus()==1){
                        status="已还";
                    }
            %>
            <tr>
                <td><%=borrows.get(i).getBorrowno() %></td>
                <td><%=borrows.get(i).getUno() %></td>
                <td><%=borrows.get(i).getBno() %></td>
                <td><%=borrows.get(i).getBname()%></td>
                <td><%=borrows.get(i).getStarttime()%></td>
                <%
                    if(borrows.get(i).getStatus()==1){
                %>
                <td><%=borrows.get(i).getEndtime()%></td>
                <%
                    }else{
                        out.print("<td>未还</td>");
                    }
                %>
                <td><%=status%></td>
                <%
                    if(borrows.get(i).getStatus()==0){
                %>
                <td><a href="/BackBookServlet?id=<%=borrows.get(i).getBorrowno() %>">还书</a></td>
                <%
                    }else if(borrows.get(i).getStatus()==1){
                %>
                <td><a href="/DeleteBorrowByBorrownoServlet?id=<%=borrows.get(i).getBorrowno() %>">删除</a></td>
                <%
                    }
                %>
            </tr>
            <%
                }
            %>
        </table>
    </div>
    <%@ include file="/part/footer.jsp"%>
</div>
</body>
</html>
