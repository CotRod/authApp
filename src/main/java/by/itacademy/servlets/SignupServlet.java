package by.itacademy.servlets;

import by.itacademy.utils.DAO;

import javax.servlet.ServletException;
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
        if(DAO.hasUser(login)){
            req.setAttribute("login",login);
            req.setAttribute("errorMsg","Choose another login");
            req.setAttribute("errorNum",2);
            this.doGet(req,resp);
        } else {
            DAO.setUser(login,password);
            req.getSession().setAttribute("login",login);
            resp.sendRedirect(getServletContext().getContextPath()+"/userHome.jsp");
        }
    }
}
