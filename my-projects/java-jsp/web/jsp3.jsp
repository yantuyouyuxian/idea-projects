<%--
  Created by IntelliJ IDEA.
  User: zh
  Date: 2020/11/16
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- @include 会将包含的页面合二为一,如果有同名的变量就会报错
           jsp:include实际上还是单独的页面--%>
    <%@include file="common/header.jsp"%>
    <h1>BODY</h1>
    <%@include file="common/footer.jsp"%>


    <jsp:include page="common/header.jsp"></jsp:include>
    <h1>Body</h1>
    <jsp:include page="common/footer.jsp"></jsp:include>

</body>
</html>
