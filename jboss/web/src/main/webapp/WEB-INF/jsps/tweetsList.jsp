<%--
  Created by IntelliJ IDEA.
  User: alehatsman
  Date: 11/24/14
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="addTweet" method="post">
        <input type="text" name="text"/>
        <input type="submit" value="tweet">
    </form>
    <table>
        <c:forEach items="${tweets}" var="item">
            <tr>
                <td>${item.text}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
