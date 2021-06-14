<%@ page import="entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link type="text/css" rel="styleSheet"  href="css/content.css" />
    </head>
    <body>
        <%
            User user=new User();
            user=(User)session.getAttribute("user");
            if (user!=null) {
                response.sendRedirect("/userpage/index_user.jsp");
            }
        %>
        <div class="html_main">
            <%@ include file="part/header.jsp"%>

            <div class="content">
                <div id="em"></div>
                <div class="login_tittle">
                    <h3>读者登录</h3>
                </div>
                <div class="my_login">
                    <form action="LoginCtrl" method="post">
                        <input type="hidden" name="type" value="0">
                        <input type="text" name="username"><br>
                        <input type="password" name="passwd"><br>
                        <input type="submit" value="登录">
                        <input type="reset" value="重置">
                    </form>
                </div>
            </div>

            <%@ include file="part/footer.jsp"%>
        </div>

    </body>
</html>
