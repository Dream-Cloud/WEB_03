<%--
  Created by IntelliJ IDEA.
  User: lifubao
  Date: 2020/2/17
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
<form method="post" action="/user.do?_method=update&id=<%=request.getParameter("id")%>">
    <label>姓名</label><input type="text" name="name" value="<%=request.getParameter("name")%>"><br>
    <label>年龄</label><input type="text" name="age" value="<%=request.getParameter("age")%>"><br>

    <%
        String sex = request.getParameter("sex");
        if (sex.equals("男")){

    %>
    <label><input name="sex" type="radio" value="男" checked="checked"/>男</label>
    <label><input name="sex" type="radio" value="女" />女</label><br>
    <%
    }else{
    %>
    <label><input name="sex" type="radio" value="男" />男</label>
    <label><input name="sex" type="radio" value="女" checked="checked"/>女</label><br>
    <%
        }
    %>

    <label>年龄</label><input type="text" name="addr" value="<%=request.getParameter("addr")%>"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
