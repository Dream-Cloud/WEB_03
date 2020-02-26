<%--
  Created by IntelliJ IDEA.
  User: lifubao
  Date: 2020/2/16
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=pageContext.getAttribute("pageContext")%><br>
<%=request.getAttribute("request")%><br>
<%=session.getAttribute("session")%><br>
<%=application.getAttribute("application")%><br>
</body>
</html>
