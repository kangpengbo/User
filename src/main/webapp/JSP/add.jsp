<%--
  Created by IntelliJ IDEA.
  User: 康蓬勃
  Date: 2019/9/16
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/UserWeb/adduser" method="post">
        用户名：<input type="text" name="username"><br><br>
        密码：<input type="text" name="password"><br><br>
        生日： <input type="text" name="birthday"><br><br>
        性别： <input type="text" name="sex"><br><br>
        <button type="submit">提交</button>
    </form>
</body>
</html>
