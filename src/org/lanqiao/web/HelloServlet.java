package org.lanqiao.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//注解方式
//@WebServlet("/hello")
//@WebServlet(value = "/hello",name = "hello")
//@WebServlet(value = "/hello",name = "hello", initParams = {@WebInitParam(name = "username",value = "张三"),@WebInitParam(name = "age",value = "22")})
@WebServlet(value = "/hello",name = "hello", initParams = {@WebInitParam(name = "username",value = "张三"),@WebInitParam(name = "age",value = "22")},loadOnStartup = 10)
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello Servlet.......");
//      获取servlet的配置信息
        ServletConfig config = this.getServletConfig();
        String name = config.getServletName();//注解情况下，name默认为servlet的全类名
        System.out.println(name);
//      获取初始化参数
        String username = config.getInitParameter("username");
        String age = config.getInitParameter("age");
        System.out.println(username + "-----" + age);

        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("hello");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
