package com.zh.filter;


import java.io.IOException;

import javax.servlet.*;

public class CharacterEncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init()");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("doFilter()前");
        chain.doFilter(request,response);
        System.out.println("doFilter()后");
    }

    public void destroy() {
        System.out.println("destroy()");
    }
}
