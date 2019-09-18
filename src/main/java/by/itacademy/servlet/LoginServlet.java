package by.itacademy.servlet;

import by.itacademy.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(DAO.getInstance().hasUser(login) && password.equals(DAO.getInstance().getUser(login).getPassword())){
            req.getSession().setAttribute("login", login);
            resp.addCookie(new Cookie("myAppUserCookie",DAO.getInstance().getUser(login).toString()));
            resp.sendRedirect(getServletContext().getContextPath()+"/userHome.jsp");
        }else {
            req.setAttribute("errorNum",1);
            req.setAttribute("errorMsg", "Wrong login or password");
            this.doGet(req,resp);
        }
    }
}
