<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 정보 조회</title>
<link href="procss.css" rel="stylesheet" type="text/css">
</head>
<body>
<div>
	<ul>
		<li><a href="./">처음으로</a></li>
		<li><a href="inputFrm.jsp">제품 등록</a></li>
		<li><a href="./dataoutput" class="act">제품 정보 조회</a></li>
		<li><a href="searchFrm.jsp">제품 검색</a></li>
		<li><a href="updateFrm.jsp">제품 수정</a></li>
		<li><a href="deleteFrm.jsp">제품 삭제</a></li>
	</ul>
</div>
<div class="section">
	<table border="1" bgcolor="white">
		<tr>
			<th>제품코드</th>
			<th>제품명</th>
			<th>가격</th>
			<th>제품유형</th>
			<th>수량</th>
		</tr>
		<c:forEach var="data" items="${pList}">
			<tr>
				<td>${data.p_code}</td>
				<td>${data.p_name}</td>
				<td>${data.p_price}</td>
				<td>${data.p_type}</td>
				<td>${data.p_amount}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>