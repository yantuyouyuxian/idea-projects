<%--
  Created by IntelliJ IDEA.
  User: zh
  Date: 2020/11/16
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%-- 脚本代码会被搬到_jsp.java文件中--%>
<%
    String name1=(String)pageContext.findAttribute("name1");
    String name2=(String)pageContext.findAttribute("name2");
    String name3=(String)pageContext.findAttribute("name3");
    String name4=(String)pageContext.findAttribute("name4");
%>
<%--使用el表达式 ${} 输出--%>
<h1>取值</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
</body>
</html>
