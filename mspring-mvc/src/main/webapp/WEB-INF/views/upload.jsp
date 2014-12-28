<%--
  Created by IntelliJ IDEA.
  User: alehatsman
  Date: 12/28/14
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>
    <form method="POST" enctype="multipart/form-data" action="/upload">
        File to upload: <input type="file" name="file"><br/>
        Name: <input type="text" name="name"><br/> <br/>
        <input type="submit" value="Upload"> Press here to upload the file!
    </form>
</body>
</html>
