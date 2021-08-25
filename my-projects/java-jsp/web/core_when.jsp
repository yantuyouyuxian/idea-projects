<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zh
  Date: 2020/11/17
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- --%>
<c:set var="score" value="88"/>
<c:choose>
    <c:when test="${score>=90}">
        score >= 90
    </c:when>
</c:choose>

</body>
</html>
