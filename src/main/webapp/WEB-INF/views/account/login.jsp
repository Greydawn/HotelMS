<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>登录</title>
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
</head>
<body>

<form action="${ctx}/login" method="post">
    <label for="userid">账号：</label>
    <input type="text" id="userid" name="userid"><br>
    <label for="userpwd">密码：</label>
    <input type="password" id="userpwd" name="userpwd"><br>
    <button type="submit" >登录</button>
    <button type="submit" >重置</button>
</form>

</body>
</html>
