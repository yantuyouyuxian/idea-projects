package com.zh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookie_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out=resp.getWriter();
        Cookie[] cookies=req.getCookies();
        if(cookies!=null){
            out.print("上一次访问的时间是：");
            for(int i=0;i<cookies.length;i++){
                Cookie cookie=cookies[i];
                if(cookie.getName().equals("lastLoginTime")){
                    long l=Long.parseLong(cookie.getValue());
                    Date date=new Date(l);
                    out.write(date.toLocaleString());
                }
            }
        }else{
            out.write("第一次访问！");
        }

        Cookie cookie=new Cookie("lastLoginTime",System.currentTimeMillis()+"");
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
        //删除cookie
//        Cookie cookie1=new Cookie("lastLoginTime",System.currentTimeMillis()+"");
//        cookie1.setMaxAge(0);
//        resp.addCookie(cookie1);

        //编码和解码
        String string=URLEncoder.encode("中文信息","utf-8");//
        String res= URLDecoder.decode(string,"utf-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
