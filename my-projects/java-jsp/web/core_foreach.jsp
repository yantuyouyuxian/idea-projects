<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<String> people =new ArrayList<>();
    people.add("zhang san");
    people.add("li si");
    people.add("wang wu");
    request.setAttribute("list",people);

    for (String person : people) {

    }
%>
<c:set var="name" value="name" scope="request"></c:set>
<%-- 默认的作用域为怕个--%>
<c:forEach var="people" items="${list}">
    <c:out value="${people}"/> <br/>
</c:forEach>
</body>
</html>
