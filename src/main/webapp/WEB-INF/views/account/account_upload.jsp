<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <title>文件上传</title>
</head>
<head>
    <title>Title</title>
</head>
<br>
<h2>文件上传</h2>
<form action="${ctx}/account/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadFile" />
    <c:if test="${imgPath!=null}">
        <img src="${ctx}/images/${imgPath}" style="height: 160px;width: 210px;"/>
        <br>
    </c:if>
    <input type="submit" value="上传">
</form>
<br>

</body>
</html>
