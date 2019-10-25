<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<a href="admin.jsp">Go back</a>
<form action="view.do" method="get">
		<table border="1" cellspacing="2" >
			<tr>
				<td>bookname</td>
				<td>Authorname</td>
				<td>price</td>
			</tr>
			<c:forEach items="${data}" var="b">
				<tr>
					<Td> ${b.bname } </Td>
					<Td> ${b.aname } </Td>
					<Td> ${b.price } </Td>
				</tr>
			</c:forEach>
		</table>
	
</form>
</body>
</html>