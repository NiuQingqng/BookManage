<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Niuniu
  Date: 2020/11/30
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String tipCodeStr = (String)request.getAttribute("tipCode");

    if(tipCodeStr!=null){
        int tipCode=Integer.parseInt(tipCodeStr);
%>
    <script type="text/javascript">
                 // 弹出错误信息
        var tipCode = <%=tipCode%>;
        if(tipCode==101){
            alert(tipCode+"密码或用户名错误！请重新登录！");
            window.location="/login_user.jsp"; // 跳转到登录界面
        }else if(tipCode==111){
            alert(tipCode+"密码或用户名错误！请重新登录！");
            window.location="/login_admin.jsp"; // 跳转到登录界面
        }else if (tipCode==200){
            alert(tipCode+"密码修改成功，请牢记！");
            window.location="/userpage/update_passwd.jsp"; // 跳转到修改密码界面
        }else if (tipCode==201){
            alert(tipCode+"原密码错误，请重新尝试！");
            window.location="/userpage/update_passwd.jsp"; // 跳转到修改密码界面
        }else if (tipCode==202){
            alert(tipCode+"密码修改失败，请重新尝试！");
            window.location="/userpage/update_passwd.jsp"; // 跳转到修改密码界面
        } else if (tipCode==300){
            alert(tipCode+"还书成功！");
            window.location="/userpage/borr_list.jsp"; // 跳转到借阅列表
        }else if (tipCode==301){
            alert(tipCode+"还书失败，请重新尝试！");
            window.location="/userpage/borr_list.jsp"; // 跳转到修改密码界面
        } else if (tipCode==401){
            alert(tipCode+"搜索结果为空，请再次尝试！");
            window.location="/allbook.jsp"; // 跳转到修改密码界面
        }else if (tipCode==500){
            alert(tipCode+"借书成功！");
            window.location="/userpage/borr_book.jsp"; // 跳转到借阅列表
        }else if (tipCode==501){
            alert(tipCode+"借书失败，请重新尝试！");
            window.location="/userpage/borr_book.jsp"; // 跳转到借阅列表
        }else if (tipCode==1199){
            alert(tipCode+"查询发生错误！");
            window.location="/adminpage/index_admin.jsp"; // 跳转到管理员主页
        }else if (tipCode==1100){
            alert(tipCode+"添加图书成功！");
            window.location="/QueryAllBookServlet"; // 跳转到所有图书
        }else if (tipCode==1101){
            alert(tipCode+"添加图书失败！");
            window.location="/QueryAllBookServlet"; // 跳转到所有图书
        }else if (tipCode==1110){
            alert(tipCode+"删除图书成功！");
            window.location="/QueryAllBookServlet"; // 跳转到所有图书
        }else if (tipCode==1111){
            alert(tipCode+"删除图书失败！");
            window.location="/QueryAllBookServlet"; // 跳转到所有图书
        }else if (tipCode==1121){
            alert(tipCode+"找不到图书！");
            window.location="/QueryAllBookServlet"; // 跳转到所有图书
        }else if (tipCode==1130){
            alert(tipCode+"修改图书成功！");
            window.location="/QueryAllBookServlet"; // 跳转到所有图书
        }else if (tipCode==1131){
            alert(tipCode+"修改图书失败！");
            window.location="/QueryAllBookServlet"; // 跳转到所有图书
        }else if (tipCode==1299){
            alert(tipCode+"查询发生错误！");
            window.location="/adminpage/index_admin.jsp"; // 跳转到管理员主页
        }else if (tipCode==1200){
            alert(tipCode+"添加用户成功！");
            window.location="/QueryAllUserServlet"; // 跳转到所有用户
        }else if (tipCode==1201){
            alert(tipCode+"添加用户失败！");
            window.location="/QueryAllUserServlet"; // 跳转到所有用户
        }else if (tipCode==1210){
            alert(tipCode+"删除用户成功！");
            window.location="/QueryAllUserServlet"; // 跳转到所有用户
        }else if (tipCode==1211){
            alert(tipCode+"删除用户失败！");
            window.location="/QueryAllUserServlet"; // 跳转到所有用户
        }else if (tipCode==1221){
            alert(tipCode+"找不到用户！");
            window.location="/QueryAllUserServlet"; // 跳转到所有用户
        }else if (tipCode==1230){
            alert(tipCode+"修改用户成功！");
            window.location="/QueryAllUserServlet"; // 跳转到所有用户
        }else if (tipCode==1231){
            alert(tipCode+"修改用户失败！");
            window.location="/QueryAllUserServlet"; // 跳转到所有用户
        }else if (tipCode==1300){
            alert(tipCode+"删除借阅记录成功！");
            window.location="/QueryAllBorrowServlet"; // 跳转到所有借阅记录
        }else if (tipCode==1301){
            alert(tipCode+"删除借阅记录失败，请重新尝试！");
            window.location="/QueryAllBorrowServlet"; // 跳转到所有借阅记录
        }
    </script>
<%
    }else{
        User user=(User)session.getAttribute("user");
        if (user!=null) {
            session.invalidate();
        }else {
            User admin=(User)session.getAttribute("admin");
            if (admin!=null) {
                session.invalidate();
            }
        }
%>
    <script type="text/javascript">
        alert("已退出登录");
        window.location="/"; // 状态码为空时跳转到主页
    </script>
<%
    }
%>
</body>
</html>
