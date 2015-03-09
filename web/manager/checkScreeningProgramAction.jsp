<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-7
  Time: 下午9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="MyTag" uri="/tlds/mytaglib.tld" %>
<html>
<head>
    <title>Cineplex</title>
    <jsp:include page="/base/header.jsp"/>
    <script type="text/javascript" src="/static/js/CheckSP.js"></script>
</head>
<body>
<jsp:include page="/navigater/manager_navigater.jsp"/>
<MyTag:displayUncheckedScreeningProgram/>
</body>
</html>
