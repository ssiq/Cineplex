<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-5
  Time: 下午9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title></title>
      <script type="text/javascript" src="/static/js/jquery.js"></script>
      <script type="text/javascript" src="/static/js/index.js"></script>
  </head>
  <body>
        <s:form id="login_form" method="POST">
            <select id="identity" name="type">
                <option value="0">会员</option>
                <option value="1">服务员</option>
                <option value="2">经理</option>
            </select>

            <s:textfield name="username" label="用户名"/>
            <s:password name="password" label="密码"/>
            <s:submit value="登陆"/><s:reset value="重置"/>
        </s:form>
  </body>
</html>
