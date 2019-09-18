package by.itacademy.filter;

import by.itacademy.dao.DAO;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Cookie [] cookies = req.getCookies();
        Optional<Cookie>cookie = Arrays.stream(cookies)
                .filter(c -> DAO.getInstance().hasUser(c.getName()))
                .findAny();
        if(cookie.isPresent()){
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            resp.sendRedirect(req.getContextPath()+"/login");
        }
    }
}
