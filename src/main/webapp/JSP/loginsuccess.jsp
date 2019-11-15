<%--
  Created by IntelliJ IDEA.
  User: 康蓬勃
  Date: 2019/9/16
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1px" width="800px">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>生日</th>
            <th>性别</th>
            <th><button onclick="addUser()" type="button">添加</button></th>
        </tr>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.userid}</td>
                <td>${u.username}</td>
                <td>${u.password}</td>
                <td>${u.birthday}</td>
                <td>${u.sex}</td>
                <td>
                    <button onclick="updateUser()" value="${u.username}" type="button">修改</button>
                    <button onclick="deleteUser()" type="button">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <script>
        function addUser() {
            location.href="/UserWeb/add";
        }
        function updateUser() {
            location.href="/UserWeb/update";
        }
        function deleteUser() {
            location.href="/UserWeb/delete";
        }
    </script>
</body>
</html>
