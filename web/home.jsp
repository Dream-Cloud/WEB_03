<%--
  Created by IntelliJ IDEA.
  User: lifubao
  Date: 2020/2/16
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<%--保存数据到四大域对象--%>
<%
    pageContext.setAttribute("pageContext","pageContext...");
    request.setAttribute("request","request.....");
    session.setAttribute("session","session...");
    application.setAttribute("application","application...");
%>
<%--获取域对象属性值--%>
<%=pageContext.getAttribute("pageContext")%><br>
<%=request.getAttribute("request")%><br>
<%=session.getAttribute("session")%><br>
<%=application.getAttribute("application")%><br>
<%
    request.getRequestDispatcher("/attr2.jsp").forward(request,response);
%>

<a href="attr2.jsp">跳转到attr2.jsp</a>

</body>
</html>
