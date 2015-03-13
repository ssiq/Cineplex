<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-13
  Time: 下午8:05
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
<jsp:include page="/navigater/waiter_navigater.jsp"/>
<form action="doSell" method="post">
    <MyTag:displayTable tableName="table"/>
    <select name="type">
        <option value="0">会员</option>
        <option value="1">非会员</option>
    </select>
    <br/>
    会员卡号:
    <input type="text" name="cardNumber" value=""/>
    <br/>
    <input type="submit" value="购买"/>
</form>
</body>
</html>
