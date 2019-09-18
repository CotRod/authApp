package by.itacademy.servlet;

import by.itacademy.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signup.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(DAO.getInstance().hasUser(login)){
            req.setAttribute("login",login);
            req.setAttribute("errorMsg","Choose another login");
            req.setAttribute("errorNum",2);
            this.doGet(req,resp);
        } else {
            DAO.getInstance().save(login,password);
            req.getSession().setAttribute("login",login);
            resp.addCookie(new Cookie(login, DAO.getInstance().getUser(login).toString()));        //в куку кладём логин и пароль, пока что так,потом изменить
            resp.sendRedirect(getServletContext().getContextPath()+"/userHome.jsp");
        }
    }
}
