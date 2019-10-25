<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="index.jsp">Back</a>
	<form action="add.jsp">
		<input type="submit" value="add" />
	</form>

	<form action="view.do">
		<input type="submit" value="view" />
	</form>

	<form action="update.jsp">
		<input type="submit" value="update" />
	</form>

	<form action="delete.jsp">
		<input type="submit" value="delete" />
	</form>
</body>
</html>