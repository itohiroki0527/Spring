<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>入力＆検索ページ</title>
</head>
<body>
<h2>${search_reg_mesage}</h2>
<form:form modelAttribute="searchRegForm">
		氏名<form:input path="inputName"  name="name" placeholder="例:尾中須井太"/>
			<form:errors path="inputName" cssStyle="color:red" /><br>
			住所<form:input path="inputAdress"  name="adress" placeholder="例:千葉県船橋市若松１丁目"/>
			<form:errors path="inputAdress" cssStyle="color:red" /><br>
				電話番号<form:input path="inputTel"  name="tel" placeholder="例:0471235678"/>
				<form:errors path="inputTel" cssStyle="color:red" /><br>
				宛先の氏名<form:input path="inputSendName"  name="sendname" placeholder="例:岡根星井"/>
				<form:errors path="inputSendName" cssStyle="color:red" /><br>
					遺言内容<form:input path="inputMessage"  name="message" placeholder="50文字まで"/>
					<form:errors path="inputMessage" cssStyle="color:red" /><br>
					あいことば<form:input path="inputAikotoba"  name="aikotoba" placeholder="20文字まで"/>
					<form:errors path="inputAikotoba" cssStyle="color:red" /><br>
		<input type="submit" name="send" value="送信" >
		
	</form:form>
	<form:form modelAttribute="searchRegForm">
					入力情報を表示したい場合、あいことばを入力してください<form:input path="inputInfo"  name="aikotobapass"/>
		<input type="submit" name="c" value="検索" >

		
		
		
		<c:if test="${not empty aikotobaList}">
		<c:forEach var="aikotobaForm" items="${aikotobaList}">
		<table border="1">
			
				<tr>
					<td><c:out value="${aikotobaForm.dbName}"></c:out></td>
					<td><c:out value="${aikotobaForm.dbAdress}"></c:out></td>
					<td><c:out value="${aikotobaForm.dbTel}"></c:out></td>
					<td><c:out value="${aikotobaForm.dbSendName}"></c:out></td>
					<td><c:out value="${aikotobaForm.dbAikotoba}"></c:out></td>
					<td><c:out value="${aikotobaForm.dbMessage}"></c:out></td>
				</tr>
			
		</table>
		</c:forEach>
		<br>
	</c:if>
	</form:form>
</body>
</html>