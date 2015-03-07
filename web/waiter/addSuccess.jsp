<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-7
  Time: 下午8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cineplex</title>
    <jsp:include page="/base/header.jsp"/>
</head>
<body>
<jsp:include page="/navigater/waiter_navigater.jsp"/>
<p><%=request.getAttribute("mess")%></p>
</body>
</html>
