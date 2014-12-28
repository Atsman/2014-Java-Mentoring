<%--
  Created by IntelliJ IDEA.
  User: alehatsman
  Date: 12/28/14
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Error </title>
</head>
<body>
Failed URL: ${url}
Exception: ${exception.message}
<c:forEach items="${exception.stackTrace}" var="ste">
    ${ste}
</c:forEach>
</body>
</html>
