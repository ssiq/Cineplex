<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-13
  Time: 上午11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cineplex</title>
    <jsp:include page="/base/header.jsp"/>
</head>
<body>
<jsp:include page="/navigater/member_navigater.jsp"/>
<s:form action="doRecharge" method="POST">
    <tr>
        <th>银行卡号</th>
        <td><input type="text" name="cardNumber"></td>
    </tr>
    <tr>
        <th>充值金额</th>
        <td><input type="text" name="money" class="double"></td>
    </tr>
    <tr>
        <td><input type="submit" value="充值"></td>
        <td></td>
    </tr>
</s:form>
</body>
</html>
