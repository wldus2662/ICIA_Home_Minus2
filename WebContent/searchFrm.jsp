<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 검색</title>
<link href="procss.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<ul>
			<li><a href="./">처음으로</a></li>
			<li><a href="inputFrm.jsp">제품 등록</a></li>
			<li><a href="./dataoutput">제품 정보 조회</a></li>
			<li><a href="searchFrm.jsp" class="act">제품 검색</a></li>
			<li><a href="updateFrm.jsp">제품 수정</a></li>
			<li><a href="deleteFrm.jsp">제품 삭제</a></li>
		</ul>
	</div>
	<div class="section">
		<form action="./datasearch">
			<p>
				제품코드 입력 : <input type="text" name="p_code">
			</p>
			<p>
				<input type="submit" value="검색">
			</p>
		</form>
	</div>
</body>
</html>




