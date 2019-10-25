<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
<a href="admin.jsp">Go back</a>
<h1>books</h1>
	<form action="addservlet.do" method="post">
	<table>
	<tr>
		<td>Book name:<input type="text" name="bname" /><br /> <br /></td><td>
		Author name:<input type="text" name="aname" /><br /> <br /></td>
		 <td>price:<input type="number" name="price" required /><br /> <br /> </td>
		 <input type="submit" value="add" />
			</table>
	</form>


</body>
</html>