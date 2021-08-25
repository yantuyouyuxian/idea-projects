package com.zh.Listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session id:"+se.getSession().getId());
        ServletContext context = se.getSession().getServletContext();
        Integer onLineCount = (Integer) context.getAttribute("OnLineCount");
        if (onLineCount == null) {
            onLineCount = new Integer(1);
        } else {
            int count = onLineCount.intValue();
            onLineCount = new Integer(count+1);
        }
        context.setAttribute("OnLineCount", onLineCount);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        {
            ServletContext context = se.getSession().getServletContext();
            se.getSession().invalidate();
            Integer onLineCount = (Integer) context.getAttribute("OnLineCount");
            if (onLineCount == null) {
                onLineCount = new Integer(0);
            } else {
                int count = onLineCount.intValue();
                onLineCount = new Integer(count-1);
            }
            context.setAttribute("OnLineCount", onLineCount);
        }
    }

}
