<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/11/7
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="/uploadUrl" method="post" enctype="multipart/form-data">
    <input type="file" name="images" multiple="multiple" />
    <input type="submit" value="文件上传" />
</form>
</body>
</html>
