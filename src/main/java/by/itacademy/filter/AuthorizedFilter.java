package by.itacademy.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class AuthorizedFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Cookie[] cookies = req.getCookies();
        Optional<Cookie> cookie = Arrays.stream(cookies)
                .filter(c -> c.getName().equals("myAppUserCookie"))
                .findAny();
        if(cookie.isPresent()){
            resp.sendRedirect(req.getContextPath()+"/userHome.jsp");
        } else {
            filterChain.doFilter(servletRequest,servletResponse);

        }
    }
}
