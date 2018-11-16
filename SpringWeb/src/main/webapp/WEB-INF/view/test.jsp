<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/11/5
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:form action="" method="post" modelAttribute="person">
        ID:<s:input path="id"/> <s:errors path="id" cssClass="error"/><br/>
        Name:<s:input path="name"/><s:errors path="name" cssClass="error"/><br/>
        Age:<s:input path="age"/><s:errors path="age" cssClass="error"/><br/>
        <input type="button"  value="提交"/>
    </s:form>
</body>
</html>
