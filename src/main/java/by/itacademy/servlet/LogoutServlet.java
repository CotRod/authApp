package by.itacademy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("myAppUserCookie","");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        resp.sendRedirect(getServletContext().getContextPath()+"/login");
    }
}
