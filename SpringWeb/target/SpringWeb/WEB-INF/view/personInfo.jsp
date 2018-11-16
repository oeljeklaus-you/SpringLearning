<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/11/5
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Person Info</title>
</head>
<body>
    <div>
        <div><c:out value="${person.id}"/></div>
        <div><c:out value="${person.name}"/></div>
        <div><c:out value="${person.age}"/></div>
    </div>
</body>
</html>
