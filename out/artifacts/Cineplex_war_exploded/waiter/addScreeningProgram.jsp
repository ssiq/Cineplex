<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-7
  Time: 下午5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="MyTag" uri="/tlds/mytaglib.tld" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Cineplex</title>
    <jsp:include page="/base/header.jsp"/>
</head>
<body>
    <jsp:include page="/navigater/waiter_navigater.jsp"/>
    <p><MyTag:displayErrorMessage/></p>
    <s:form action="doAddScreeningProgram">
        <jsp:include page="ScreeningProgramInput.jsp"/>
        <input type="submit" value="提交"/>
    </s:form>
</body>
</html>
