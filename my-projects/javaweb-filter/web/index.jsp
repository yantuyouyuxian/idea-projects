<%--
  Created by IntelliJ IDEA.
  User: zh
  Date: 2020/11/18
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>当前有<span><%=this.getServletConfig().getServletContext().getAttribute("OnLineCount")%></span>人在线</h1>
  <h2>当前有<span style="color: deepskyblue"><%=application.getAttribute("OnLineCount")%></span>人在线</h2>
  <h3>当前有<span style="color: lightskyblue">${OnLineCount}</span>人在线</h3>
  <%-- 采用EL表达式 对于属性的访问的隐含访问顺序是
    pageContext,  httpServletRequest,  HttpSession,  ServletContext
  --%>
  </body>
</html>
