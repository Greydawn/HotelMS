<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head lang="en">
    <meta charset="UTF-8">
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <title>首页</title>
</head>
<body>

<script>

    $(function () {
		window.location.href = '${ctx}/account/dashboard';
    });


</script>
</body>
</html>