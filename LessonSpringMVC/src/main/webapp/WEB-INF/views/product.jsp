<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>Product</title>
</head>
<body>
	<p>
		<c:out value="${message}" />
	</p>
	<form:form modelAttribute="productForm">
名前<form:input path="name" />
		<br />
価格<form:input path="price" />
		<br />
		<input type="submit" value="送信">
		<br />
	</form:form>
	<c:if test="${not empty productList}">
		<table border="1">
			<tr>
				<th>名前</th>
				<th>価格</th>
			</tr>
			<c:forEach var="productForm" items="${productList}">
				<tr>
					<td><c:out value="${productForm.name}"></c:out></td>
					<td><c:out value="${productForm.price}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</c:if>
</body>
</html>