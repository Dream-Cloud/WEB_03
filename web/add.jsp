<%--
  Created by IntelliJ IDEA.
  User: lifubao
  Date: 2020/2/17
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form method="post" action="/user.do?_method=add">
    <label>姓名</label><input type="text" name="name" ><br>
    <label>年龄</label><input type="text" name="age" ><br>
    <label><input name="sex" type="radio" value="男" />男</label>
    <label><input name="sex" type="radio" value="女" />女</label><br>

    <label>年龄</label><input type="text" name="addr" ><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
