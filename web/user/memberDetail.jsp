<%--
  Created by IntelliJ IDEA.
  User: wlw
  Date: 15-3-14
  Time: 下午9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="MyTag" uri="/tlds/mytaglib.tld" %>
<div>
    <div>
        <p>会员信息</p>
        <MyTag:displayTable tableName="detail"/>
    </div>

    <div>
        <p>缴费记录</p>
        <table>
            <tr>
                <MyTag:displayTableTitle titleName="rechargeTitle"/>
            </tr>
            <MyTag:displayTableBody bodyName="rechargeBody"/>
        </table>
    </div>

    <div>
        <p>消费记录</p>
        <table>
            <tr>
                <MyTag:displayTableTitle titleName="buyTitle"/>
            </tr>
            <MyTag:displayTableBody bodyName="buyBody"/>
        </table>
    </div>
</div>
