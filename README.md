# 1、servlet注解

## 1.1、基于注解的servlet开发

```java
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello Servlet .....");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Hello");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

```java
@WebServlet(name = "hello",value = "/hello",initParams ={@WebInitParam(name="username",value = "张三"),@WebInitParam(name="age",value="22")},loadOnStartup = 10)
```

![img](E:\YouDaoYun\m15234512314@163.com\1489a59d627e42d4bed944a2b9ff04e3\clipboard.png)

![img](E:\YouDaoYun\m15234512314@163.com\1091a06175aa42849f46437f49240e49\clipboard.png)

# 2、jsp概述

JSP：jsp是Java所提供的一种web的动态视图技术

JSP = html + css + js + jsp指令/脚本片段

```jsp
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--导包--%>
<%--
  Created by IntelliJ IDEA.
  User: Adminstrator
  Date: 2020/2/13
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>这是一个jsp页面</title>
  </head>
  <body>
<%--   jsp的注释
  <%...%>：Java语句；
  <%=…%>：Java表达式；
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
  </body>
</html>
```

jsp的本质：

当运行的时候 jsp会被我们的web容器翻译成index_jsp.java一个serlvet  在进行编译 运行

jsp的本就就是一个servlet

  <%...%>：Java语句； 所有的语句  都包含在_jspService方法中 

  <%=…%>：Java表达式；使用out.print进行输出

  <%!  ... %>:类的成员  可以是成员变量  也可以是成员方法

# 3、jsp九大内置对象

### 内置对象 就是不需要定义就可以 直接使用的对象 ：

1. final javax.servlet.http.HttpServletRequest request

```jsp
<%--表达式后边不能有分号出现--%>  

<%=request.getParameter("username")%>
```

2. final javax.servlet.http.HttpServletResponse response  （几乎不用）

```jsp
<%=response instanceof  HttpServletResponse %>
```

3. final javax.servlet.jsp.PageContext pageContext;

pageContext代表整个页面的抽象对象 可以从其中获取其他八大对象

```jsp
<%=pageContext.getRequest().getParameter("username")%>
```

4. javax.servlet.http.HttpSession session = null;

```jsp
<%=session.getId()%>
```

5. final javax.servlet.ServletContext application;

   

6. final javax.servlet.ServletConfig config;

   

7. javax.servlet.jsp.JspWriter out = null;

```jsp
  <%=application.getInitParameter("app")%>
<%--表达式会最终被翻译为--% out.print(）>--%>
  <%
      out.print(application.getInitParameter("app"));
  %>
  <%
      out.print(config.getInitParameter("username"));
  %>
```

8. final java.lang.Object page = this;

   ​		**page 指向当前jsp对应的servlet对象的，但为object类型，只能使用object类的方法。开发中几乎不用**。

9. java.lang.Throwable exception  只有page指令中的iserrorPage = true的时候 才可以使用该内置对象

### 四大域对象

pageContext

request

session

application

同时四大域对象都有以下方法

- setAttribute（String key ,Object value）
- getAttribute(String key)
- removeAttribute(String key)

域属性的范围：

pageContext< request < session<application

- pageContext不能跨页面获取 直在当前页面有效
- request ： 只能获取属于同一次请求的  转发可以   超链接不可以
- session: 属于同一次会话
- application：只要服务器没有重启  都可以获取。