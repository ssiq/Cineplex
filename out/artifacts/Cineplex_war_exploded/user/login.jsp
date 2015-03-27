<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-6
  Time: 下午6:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title></title>
</head>
<body>
<s:form action="doLogin" method="POST">
    <table>
        <tr>
            <th>用户名</th>
            <td><input required="true" name="username" type="text" value="<s:property value="username"/>"/> </td>
        </tr>
        <tr>
            <th>密码</th>
            <td><input required="true" name="password" type="password" value="<s:property value="password"/>"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="登陆"/></td>
            <td><input type="reset" value="重置"/></td>
        </tr>
    </table>
</s:form>
</body>
</html>
