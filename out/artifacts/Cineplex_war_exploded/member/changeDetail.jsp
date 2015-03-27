<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-14
  Time: 下午10:26
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
<s:form action="doChangeMyDetail" method="POST">
    <table>
        <tr>
            <th>用户名</th>
            <td><s:property value="user.username"/></td>
        </tr>
        <tr>
            <th>密码</th>
            <td><input type="password" name="user.password" value="<s:property value="user.password"/>"/></td>
        </tr>
        <tr>
            <th>性别</th>
            <td><input type="text" name="memberDetail.sex" value="<s:property value="memberDetail.sex"/>"/></td>
        </tr>
        <tr>
            <th>住址</th>
            <td><input type="text" name="memberDetail.place" value="<s:property value="memberDetail.place"/>"/></td>
        </tr>
        <tr>
            <th>年龄</th>
            <td><input type="text" name="memberDetail.age" value="<s:property value="memberDetail.age"/>"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"/></td>
            <td></td>
        </tr>
    </table>
</s:form>
</body>
</html>
