<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<a href="admin.jsp">Go back</a>
<form action="Update.do" method="post">
Enter the Name of the book to update:
<input type="text" name="update">
New Name:<input type="text" name="nname">
New Author:<input type="text" name="author">
New Price:<input type="number" name="price">
<input type="submit" value="Update">



</form>

</body>
</html>