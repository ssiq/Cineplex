<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-6
  Time: 下午10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="MyTag" uri="/tlds/mytaglib.tld" %>
<html>
<head>
    <title>Cineplex</title>
    <jsp:include page="/base/header.jsp"/>
</head>
<body>
<jsp:include page="/navigater/manager_navigater.jsp"/>

<p><MyTag:displayErrorMessage/></p>

<s:form action="doAddFilmOffice" method="POST">
    <table>
        <tr>
            <th>影厅名称</th>
            <td><input required="true" type="text" name="filmOffice.filmOfficeName" value="<s:property value="filmOffice.filmOfficeName"/>"></td>
        </tr>
        <tr>
            <th>影厅大小</th>
            <td><input required="true" type="text" name="filmOffice.size" value="<s:property value="filmOffice.size"/>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td></td>
        </tr>
    </table>
</s:form>
</body>
</html>
