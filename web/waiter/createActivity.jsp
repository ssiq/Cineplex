<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-13
  Time: 下午11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cineplex</title>
    <jsp:include page="/base/header.jsp"/>
    <script type="text/javascript" src="/static/js/addActivity.js"></script>
</head>
<body>
<jsp:include page="/navigater/waiter_navigater.jsp"/>
<form action="doCreateActivity" method="post">
    <s:select list="filmList" label="电影" name="activity.filmName"/>
    <div>
        <label>标题</label><input name="activity.title" type="text"/>
    </div>
    <table>
        <tr>
            <th>题目</th>
            <th>选项</th>
        </tr>

        <tr>
            <td><input type="button" value="加一条题目" id="add"/></td>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
