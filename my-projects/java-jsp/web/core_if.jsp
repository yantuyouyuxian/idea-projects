
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/xml" %>
--%>
<html>
<head>
    <title>Title</title>
</head>

<body>
    <form action="core_if.jsp" method="get">
        <input type="text" name="username" value="${param.username}">
        <input type="submit" value="submit">
    </form>
<%--
<%
    if(request.getParameter("username").equals("admin")){
        out.print("admin");
    }
%>
--%>
<c:if test="${param.username=='admin'}" var="isadmin">
    <c:out value=" admin welcome"></c:out>
</c:if>

<c:out value="var is ${isadmin}"></c:out>

</body>
</html>
