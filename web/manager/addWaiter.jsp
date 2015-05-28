<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-6
  Time: 下午8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title></title>
</head>
<body>
    <jsp:include page="/navigater/manager_navigater.jsp"/>
    <p><%
        String str=(String)request.getAttribute("mess");
        if(str!=null){
            out.print(str);
        }
    %></p>
    <s:form action="doAddWaiter" method="POST">
        <table>
            <tr>
                <th>用户名</th>
                <td><input name="user.username" type="text" value="<s:property value="user.username"/>"></td>
            </tr>
            <tr>
                <th>密码</th>
                <td><input name="user.password" type="text" value="<s:property value="user.password"/>"></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
                <td></td>
            </tr>
        </table>
    </s:form>
</body>
</html>
