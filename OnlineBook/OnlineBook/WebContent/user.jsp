<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>User</title>
</head>
<body>
	<a href="index.jsp">Back</a>
	<form  action="search.do" method="post">

		<input type="text" name="search"> <input type="submit"
			value="Search"> 
	<br><br>

	<table border="1">
		<tr>
			<td>bookname</td>
			<td>Authorname</td>
			<td>Price</td><td></td><td></td>
		</tr>
		<c:forEach items="${data}" var="b">
			<tr>
				<Td>${b.bname }</Td>
				<Td>${b.aname }</Td>
				<Td>${b.price }</Td>
				
				<td><button type="submit"> <a href="addrev.do&bookName=${b.bname}">add review</a></td>
				<td><button type="submit"> <a href="addreview.jsp">view review</a></td>
			</tr>
		</c:forEach>
	</table>
</form>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>