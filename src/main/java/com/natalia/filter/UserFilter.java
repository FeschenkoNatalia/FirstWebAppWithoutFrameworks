package com.natalia.filter;

import com.natalia.dao.UserDao;
import com.natalia.dao.UserDaoImpl;
import com.natalia.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static com.natalia.factory.Factory.getConnection;

public class UserFilter implements Filter {

    private UserDao userDao;
    private final String TOKEN = "TOKEN";
    private final Set<String> protectedUrL = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    //    userDao = new UserDaoImpl(ConnectionPool.getConnection());
        userDao = new UserDaoImpl(getConnection());
        protectedUrL.add("/root/users");
        protectedUrL.add("/root/categories");
      //  protectedUrL.add("/root/signin");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Cookie[] cookies = req.getCookies();
        String uri = req.getRequestURI();
        if (protectedUrL.contains(uri)) {
            String token = null;
            for (Cookie cookie: cookies) {
                String name = cookie.getName().toUpperCase();
                if (TOKEN.equals(name)) {
                    token = cookie.getValue();
                    User user = userDao.findByToken(token);
                    req.setAttribute("userId", String.valueOf(user.getUserId()));
                }
            }
            if (token == null) {
                req.getRequestDispatcher("/WEB-INF/signUp.jsp").forward(req, res);
            }
        }
        chain.doFilter(request, res);
    }
    @Override
    public void destroy() {
    }
}
