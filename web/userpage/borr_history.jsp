<%@ page import="entity.Borrow" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.User" %>
<%@ page import="service.BorrowService" %><%--
  Created by IntelliJ IDEA.
  User: Niuniu
  Date: 2020/11/29
  Time: 21:14
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
    }else {
        BorrowService borrowService = new BorrowService();
        ArrayList<Borrow> borrowlist =borrowService.queryBorrowByStatus(user.getUno(),1);
%>
    <%@ include file="/part/header.jsp"%>
    <div class="content">
        <table>
            <caption><%=user.getUname() %>的借阅记录</caption>
            <tr>
                <td>记录编号</td>
                <td>书名</td>
                <td>借阅时间</td>
                <td>归还时间</td>
                <td>状态</td>
            </tr>
            <%
                String status="未知";

                for(int i=0;i<borrowlist.size();i++){
                    if(borrowlist.get(i).getStatus()==1){
                        status="已还";
                    }
            %>
            <tr>
                <td><%=borrowlist.get(i).getBorrowno() %></td>
                <td><%=borrowlist.get(i).getBname()%></td>
                <td><%=borrowlist.get(i).getStarttime()%></td>
                <td><%=borrowlist.get(i).getEndtime()%></td>
                <td><%=status%></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
    <%@ include file="/part/footer.jsp"%>
<%
    }
%>
</div>
</body>
</html>
