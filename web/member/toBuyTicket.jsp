<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-12
  Time: 下午8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="MyTag" uri="/tlds/mytaglib.tld" %>
<html>
<head>
    <title>Cineplex</title>
    <jsp:include page="/base/header.jsp"/>
</head>
<body>
<jsp:include page="/navigater/member_navigater.jsp"/>
<form action="doBuy" method="post">
    <MyTag:displayTable tableName="table"/>
    <input type="submit" value="购买"/>
</form>
</body>
</html>
