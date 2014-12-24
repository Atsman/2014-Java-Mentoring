<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<title>Tweet list</title>
</head>
<body>
	<h1>Tweet list</h1>
	<ul>
	 	<c:forEach items="${tweets}" var="tweet">
	 		<li> 
	 			${tweet.text}
	 			<a href="${pageContext.request.contextPath}/tweets/${tweet.id}">update</a>
	 			<form:form action="${pageContext.request.contextPath}/tweets/${tweet.id}" method="POST">
	 				<input type="hidden" name="_method" value="delete">
	 				<input type="submit" value="delete">
	 			</form:form>
 			</li>
	 	</c:forEach>
 	</ul>
</body>
</html>