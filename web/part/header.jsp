<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .nav{
            width: 100%;
            height: 50px;
            border-radius: 5px;
            background-color: cornflowerblue;
        }
        .nav ul a li:hover{
            background-color: greenyellow;
        }
        .nav li{
            background-color: green;
            display: inline;
            margin: 5px 0 0 30px;
            padding: 0 15px;
            border-radius: 5px;
            line-height: 40px;
            float:left;
            color: white;
            text-decoration:none;
            font-size: 18px;
        }
    </style>
</head>
<body>
<header>
    <a href="/"><img src="/img/logo.png"></a>
    <div class="nav">
        <ul>
            <a href="/"><li>图书主页</li></a>
            <a href="/allbook.jsp"><li>藏书查询</li></a>
            <a href=""><li>分类查看</li></a>
            <a href=""><li>图书推荐</li></a>
            <a href="/login_user.jsp"><li>读者服务</li></a>
            <a href="/login_admin.jsp"><li>图书管理</li></a>
        </ul>
    </div>
</header>
</body>
</html>
