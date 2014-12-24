<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Create tweet</title>
</head>
<body>
	<h1>Create tweet</h1>
 	<form:form servletRelativeAction="/tweets" method="POST" commandName="tweet">
 		<textarea name="text" rows="10" cols="40"></textarea>
 		<input type="submit" value="Submit">
 	</form:form>
</body>
</html>