<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
<h1>Index</h1>

<table>
<thead>
<th>Id</th>
<th>Name</th>
</thead>
<tbody>

<c:forEach var="book" items="${result}">
<tr>
	<td>${book.id}</td>
	<td>${book.bookName}</td>
	</tr>
</c:forEach>


</tbody>


</table>

</body>
</html>