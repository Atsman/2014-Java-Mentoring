<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Update tweet</title>
</head>
<body>
	<h1>Update tweet</h1>
 	<form:form servletRelativeAction="/tweets/${tweet.id}" method="POST" commandName="tweet">
 		<input type="hidden" name="_method" value="PUT">
 		<input type="hidden" name="id" value="${tweet.id}">
 		<textarea name="text" rows="10" cols="40">${tweet.text}</textarea>
 		<input type="submit" value="Submit">
 	</form:form>
</body>
</html>