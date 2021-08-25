<%--
  Created by IntelliJ IDEA.
  User: zh
  Date: 2020/11/15
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>



  <%--普通工程，添加web支持，可以选择热更新--%>
  <%-- jsp的注释 --%>
  <!-- html的注释 -->

  <%= new Date()%>

  <%
    int sum=0;
    for(int i=0;i<=100;i++){
      sum+=i;
    }
    out.print("<h1>sum="+sum+"</h1>");

  %>

  <%
    int x=10;
    out.print(x);
  %>

  <p>JSP</p>

  <!--\${} EL表达式 -->
  <%  for(int i=0;i<5;i++){ %>
    <h1>hello <%=i%>  </h1>
  <%  } %>

<!--  不加！号，代码作用域都在service方法中，
      加了！的作用域为类，
      而经常使用的out，session等都是在service方法中声明的
-->
  <%!
    static{
        System.out.println("static{}");
    }

    public void func(){
      System.out.println("func()");
    }
  %>

  </body>
</html>
