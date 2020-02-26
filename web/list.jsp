<%@ page import="java.util.List" %>
<%@ page import="org.lanqiao.mvc.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: lifubao
  Date: 2020/2/16
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            border: 2px solid;
            border-spacing: 0;
        }
        td{
            border: 1px solid;
        }
    </style>
</head>
<body>
<h1>用户数据列表</h1>
<%
    List<User> users = (List<User>) request.getAttribute("users");
%>
<a href="add.jsp">添加用户</a>
<table>
    <thead>
    <tr>
        <th>用户名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>住址</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (User user:users){
    %>
    <tr>
        <td><%=user.getUsername()%></td>
        <td><%=user.getAge()%></td>
        <td><%=user.getSex()%></td>
        <td><%=user.getAddr()%></td>
        <td><a href="/user.do?_method=delete&id=<%=user.getId()%>">删除</a></td>
        <td><a href="/update.jsp?name=<%=user.getUsername()%>&age=<%=user.getAge()%>&sex=<%=user.getSex()%>&addr=<%=user.getAddr()%>&id=<%=user.getId()%>">修改</a></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
