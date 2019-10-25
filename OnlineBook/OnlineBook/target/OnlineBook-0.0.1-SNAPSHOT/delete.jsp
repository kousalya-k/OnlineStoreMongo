<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
<a href="admin.jsp">Go Back</a>
<form action="deleteservlet.do" method="get">
Enter the Name of book you want to delete:
<input type="text" name="delete">
<input type="submit" value="Remove">

</form>

</body>
</html>