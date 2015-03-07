<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-7
  Time: 下午5:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="MyTag" uri="/tlds/mytaglib.tld" %>

<table>

    <tr>
        <th>影厅</th>
        <td>
            <select name="filmOfficeName">
                <MyTag:displaySelcet/>
            </select>
        </td>
    </tr>

    <tr>
        <th>电影名称</th>
        <td><input type="text" name="screeningProgram.filmName" value="<s:property value="screeningProgram.filmName"/>"></td>
    </tr>
    <tr>
        <th>放映日期</th>
        <td><input type="date" name="screeningProgram.date" value="<s:property value="screeningProgram.date"/>"></td>
    </tr>
    <tr>
        <th>开始时间</th>
        <td><input type="text" name="screeningProgram.beginTime" value="<s:property value="screeningProgram.beginTime"/>"></td>
    </tr>
    <tr>
        <th>结束时间</th>
        <td><input type="text" name="screeningProgram.endTime" value="<s:property value="screeningProgram.endTime"/>"></td>
    </tr>
    <tr>
        <th>价格</th>
        <td><input type="text" name="screeningProgram.price" value="<s:property value="screeningProgram.price"/>"></td>
    </tr>
    <tr>
        <th>标签（不同标签间通过“；”隔开）</th>
        <td><input type="text" name="screeningProgram.tag" value="<s:property value="screeningProgram.tag"/>"></td>
    </tr>
</table>
