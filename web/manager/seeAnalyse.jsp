<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-27
  Time: 下午4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cineplex</title>
    <jsp:include page="/base/header.jsp"/>
</head>
<body>
<jsp:include page="/navigater/manager_navigater.jsp"/>

<form action="doAnalyse" method="post">
    <label>月份：</label>
    <input type="month" name="month"/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
