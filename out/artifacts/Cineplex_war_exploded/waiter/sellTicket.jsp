<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-13
  Time: 下午7:49
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
<table>
    <tr>
        <MyTag:displayTableTitle titleName="title"/>
    </tr>
    <MyTag:displayTableBody bodyName="table_body"/>
</table>
</body>
</html>
