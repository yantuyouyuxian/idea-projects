<%@ page import="com.zh.pojo.People" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //People people=new People();
%>

<jsp:useBean id="people1" class="com.zh.pojo.People" scope="page"/>
<jsp:setProperty name="people1" property="id" value="1"/>
<jsp:setProperty name="people1" property="name" value="zh"/>
<jsp:setProperty name="people1" property="age" value="22"/>
<jsp:setProperty name="people1" property="address" value="光山"/>

id:<jsp:getProperty name="people1" property="id"/>
name:<jsp:getProperty name="people1" property="name"/>
age:<jsp:getProperty name="people1" property="age"/>
address:<jsp:getProperty name="people1" property="address"/>




</body>
</html>
