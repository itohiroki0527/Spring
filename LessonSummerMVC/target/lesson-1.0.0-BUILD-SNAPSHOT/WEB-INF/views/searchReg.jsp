<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>入力＆検索ページ</title>
</head>
<body>
<h2>${search_reg_mesage}</h2>
<form:form modelAttribute="searchRegForm">
		氏名<form:input path="inputName" />
			<form:errors path="inputName" cssStyle="color:red" /><br>
			住所<form:input path="inputAdress" />
			<form:errors path="inputAdress" cssStyle="color:red" /><br>
				電話番号<form:input path="inputTel" />
				<form:errors path="inputTel" cssStyle="color:red" /><br>
				宛先の氏名<form:input path="inputSendName" />
				<form:errors path="inputSendName" cssStyle="color:red" /><br>
					遺言内容<form:input path="inputMessage" />
					<form:errors path="inputMessage" cssStyle="color:red" /><br>
					あいことば<form:input path="inputAikotoba" />
					<form:errors path="inputAikotoba" cssStyle="color:red" /><br>
		<input type="submit" name="send" value="送信" >
	</form:form>
</body>
</html>