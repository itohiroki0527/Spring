<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>confirm</title>
</head>
<body>
<p>下記内容で登録しますが宜しいでしょうか</p>

	<form:form modelAttribute="sendConfirmForm">
	<p>氏名<c:out value="${sendConfirmFormName}"></c:out></p>
	<p>住所<c:out value="${sendConfirmFormAddress}"></c:out></p>
	<p>電話番号<c:out value="${sendConfirmFormTel}"></c:out></p>
	<p>宛先の氏名<c:out value="${sendConfirmFormSendname}"></c:out></p>
	<p>遺言内容<c:out value="${sendConfirmFormMessage}"></c:out></p>
	<p>あいことば<c:out value="${sendConfirmFormAikotoba}"></c:out></p>
<p><input type="submit" name="a" value="修正" >
<input type="submit" name="b" value="送信" ></p>
</form:form>

</body>
</html>