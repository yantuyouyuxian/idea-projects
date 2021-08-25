package com.zh.filter;

import com.zh.util.Constant;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1=(HttpServletRequest) request;
        HttpServletResponse response1=(HttpServletResponse)response;
        if(request1.getSession().getAttribute(Constant.USER_SESSION) ==null){
            response1.sendRedirect("/javaweb_filter_war_exploded/login.jsp");
        }

        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
