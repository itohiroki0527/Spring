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
	名前<form:input path="name" placeholder="名前を入力してください" />
		<form:errors path="name" cssStyle="color:red" />
		<br />
	価格<form:input path="price" placeholder="0" />
		<form:errors path="price" cssStyle="color:red" />
		<br />
		<input type="submit" value="送信">
		<br />
	</form:form>
</body>
</html>