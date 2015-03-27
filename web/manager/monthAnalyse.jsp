<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-27
  Time: 下午4:34
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
<%@ taglib prefix="MyTag" uri="/tlds/mytaglib.tld" %>

<MyTag:displayMaps name="analyse_result"/>

<p>该月每天的人数统计</p>
<MyTag:displayTable tableName="countDay"/>

<div>
    <p>该月的总人数</p><%=request.getAttribute("countMonth")%>
</div>

</body>
</html>
