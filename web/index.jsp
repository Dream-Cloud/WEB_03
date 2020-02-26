<%--
  Created by IntelliJ IDEA.
  User: lifubao
  Date: 2020/2/13
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--导包--%>
<html>
<head>
  <title>这是一个jsp页面</title>
</head>
<body>
<%--   jsp的注释
  <%...%>：Java语句；
  <%=…%>：Java表达式；
  <%! ... %>为index_jsp这个类添加类属性或方法
--%>
<h1 style="color: red">这是一个jsp页面</h1>
<%--jsp的脚本片段--%>
<%
  Date date = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
  String dateStr = sdf.format(date);
%>
<%=dateStr%>
<%-- 定义一个变量  是一个成绩 根据成绩来判断      --%>
<%
  int score = 89;
  if(score< 0 || score >100){
%>
<h3>你所输入的数据非法</h3>
<%
}else{
  if(score >= 90){
%>
<h3 style="color:red">你的成绩判定为A</h3>
<%
}else if(score >=80 && score < 90){
%>
<h3 style="color:gold">你的成绩判定为B</h3>
<%
    }
  }
%>
<%!
  int num = 20;
  public void test(){

  }
%>
<%--表达式后面不能用分号出现--%>
<%=request.getParameter("username")%>
<%=response instanceof HttpServletResponse%>
<%=pageContext.getRequest().getParameter("username")%>
<%=session.getId()%>
<%=application.getInitParameter("app")%>
<%--表达式最终会翻译成 out.print()--%>
<%
  out.print(application.getInitParameter("app"));
%>
<%
  out.print(config.getInitParameter("username"));
//  int i = 1/0;


%>
<%--只有page指令中的isErrorpage=true时，才可以使用该内置对象--%>
<%--<%=exception.getClass()%>--%>
</body>
</html>
