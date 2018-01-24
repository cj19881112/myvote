package com.cj.vote.filter;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebFilter(filterName = "uidFilter", urlPatterns = "/*")
public class UidFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        Cookie[] cookies = req.getCookies();
        String uid = "";
        for (Cookie cookie : cookies) {
            if ("uid".equals(cookie.getName())) {
                uid = cookie.getValue();
            }
        }
        if (StringUtils.isEmpty(uid)) {
            uid = UUID.randomUUID().toString();
            resp.addCookie(new Cookie("uid", uid));
        }
    }

    @Override
    public void destroy() {

    }
}
