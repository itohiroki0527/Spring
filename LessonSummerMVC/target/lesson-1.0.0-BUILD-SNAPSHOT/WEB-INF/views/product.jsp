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
<<<<<<< HEAD
	名前<form:input path="name" placeholder="名前を入力してください" />
		<form:errors path="name" cssStyle="color:red" />
		<br />
	価格<form:input path="price" placeholder="0" />
		<form:errors path="price" cssStyle="color:red" />
=======
名前<form:input path="name" />
		<br />
価格<form:input path="price" />
>>>>>>> b291c6ddc282ebe63011b8d890f0e83bb29546e6
		<br />
		<input type="submit" value="送信">
		<br />
	</form:form>
<<<<<<< HEAD
=======
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
>>>>>>> b291c6ddc282ebe63011b8d890f0e83bb29546e6
</body>
</html>