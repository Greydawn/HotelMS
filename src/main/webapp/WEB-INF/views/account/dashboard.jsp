<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>首页</title>
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
</head>
<body>

<h1 style="color: red;font-family: '宋体' ">welcome to my index page!</h1>
<a href="${ctx}/account/add">添加新账户</a><br>
<a href="${ctx}/account/findAll">查看所有账户</a><br>
<a href="${ctx}/account/toupload">去上传</a><br>
<br>
<input type="text" id="searchIn" name="id">
<button onclick="searchById();" >查询</button>
<br>

<script type="text/javascript">

    function searchById(){
        var searchid=$('#searchIn').val();
        window.open("${ctx}/account/find/"+searchid);
        console.log("searchId = "+searchid);
    }
</script>
</body>
</html>
