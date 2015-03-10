<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-9
  Time: 下午8:14
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
<s:form action="doChangeMyScreeningProgram" method="POST">
    <input type="hidden" name="screeningProgram.screeningProgramId" value="<s:property value="screeningProgram.screeningProgramId"/>"/>
    <jsp:include page="ScreeningProgramInput.jsp"/>
    <input type="submit" value="提交"/>
</s:form>
</body>
</html>
