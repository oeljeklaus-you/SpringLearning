<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/11/5
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Register cn.edu.hust.bean.Person Info</title>
</head>
<body>
    <form action="/register" method="post">
        <div>id:<input type="text" name="id" value=""></div><br/>
        <div>name:<input type="text" name="name" value=""></div><br/>
        <div>age:<input type="text" name="age" value=""></div><br/>
        <div><input type="submit" value="提交"></div><br/>
    </form>
</body>
</html>
