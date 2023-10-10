<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>고객 리스트</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>AGE</th>
			<th>ENTRYDATE</th>
		</tr>
		<c:forEach var="customer" items="${customerList}">
		<tr>
			<td>${customer.cid}</td>
			<td>${customer.cname}</td>
			<td>${customer.cemail}</td>
			<td>${customer.cage}</td>
			<td>${customer.centrydate}</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>
