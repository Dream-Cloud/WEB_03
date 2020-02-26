package org.lanqiao.mvc.servlet;

import org.lanqiao.mvc.dao.UserDao;
import org.lanqiao.mvc.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user.do")
public class UserServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String _method = req.getParameter("_method");
        if (_method == null){
            _method = "";
        }
        switch (_method){
            case "add":
                add(req,resp);
                list(req, resp);
                break;
            case "delete":
                delete(req,resp);
                list(req, resp);
                break;
            case "update":
                update(req,resp);
                list(req, resp);
                break;
            default:
                list(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String addr = req.getParameter("addr");
        userDao.add(name,Integer.parseInt(age),sex,addr);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String addr = req.getParameter("addr");
        String id = req.getParameter("id");
        userDao.update(Integer.parseInt(id),name,Integer.parseInt(age),sex,addr);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        userDao.delete(Integer.parseInt(id));

    }
    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDao.list();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);

    }
}
