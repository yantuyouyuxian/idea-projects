<%--
  Created by IntelliJ IDEA.
  User: zh
  Date: 2020/11/16
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%-- 内置对象--%>

    <%

        pageContext.setAttribute("name1","pageContext");//在一个页面中有效果,跳出页面失效
        request.setAttribute("name2","request");//在一次请求中有效,请求转发会携带这个数据
        session.setAttribute("name3","session");//在一次会话中有效,从打开浏览器到关闭浏览器
        application.setAttribute("name4","application");//在服务器中有效,从打开服务器到关闭服务器

    %>
    <%-- 脚本代码会被搬到_jsp.java文件中--%>
    <%
        String name1=(String)pageContext.findAttribute("name1");
        String name2=(String)pageContext.findAttribute("name2");
        String name3=(String)pageContext.findAttribute("name3");
        String name4=(String)pageContext.findAttribute("name4");
        pageContext.forward("pageContext_02.jsp");
    %>
    <%--使用el表达式 ${} 输出--%>
    <h1>取值</h1>
    <h3>${name1}</h3>
    <h3>${name2}</h3>
    <h3>${name3}</h3>
    <h3>${name4}</h3>

</body>
</html>
