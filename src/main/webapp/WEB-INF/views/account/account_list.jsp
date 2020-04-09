<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <title>账户列表</title>
</head>
<head>
    <title>Title</title>
</head>
<br>
<h2>查询所有的账户</h2>
<form action="${ctx}/account/delete" method="post">
    <table cellpadding="1px" cellspacing="1" border="1px" style="border-collapse:collapse; ">
        <thead>
        <tr>
            <th><input type="checkbox" name="aids" value=""/></th>
            <th>账号</th>
            <th>用户名</th>
            <th>资金</th>
        </tr>
        </thead>
        <tbody>
<%--        varStatus.index就是循环的下标值 --%>
        <c:forEach items="${accountList}" var="account" varStatus="status">
            <tr>
                <td><input type="checkbox" name="aids" value="${account.id}"/></td>
                <td>${account.id}</td>
<%--                下面这条数据格式是用于表单提交多条数据，后台实体类存在一个List accountList，
这样的格式可以将参数绑定到实体类的List属性上--%>
<%--                <td><input name="accountList[${status.index}].name" value="${account.name}" /></td>--%>
                <td>${account.name}</td>
                <td>${account.money}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="submit" value="删除">
</form>
<br>

</body>
</html>
