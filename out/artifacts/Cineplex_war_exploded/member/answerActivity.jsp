<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-14
  Time: 下午5:57
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
<form method="post" action="doAnswerActivity">
    <MyTag:displayQuestion/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
