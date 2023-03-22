<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validation</title>
</head>
<body>
	<h3>Validation(유효성)검사-ex01.jsp</h3>
	<form:form method="post" modelAttribute="goodsVO">
	 	*상품명 (GOODS_TITLE) :<form:input path="goods_title"/><form:errors path="goods_title"/>
		<br/><br/>
		*상품가격(정가) (GOODS_PRICE) :<form:input path="goods_price"/><form:errors path="goods_price"/>
		<br/><br/>
		*단위가격 (unitPirce) : <form:input path="unitPrice"/><form:errors path="unitPrice"/>
		<br/><br/>
		*고유번호 (isbn) : <form:input path="isbn"/><form:errors path="isbn"/>
		<input type="submit" value="확인">
		<input type="reset"  value="취소">
	</form:form>
</body>
</html>