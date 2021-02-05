<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 삭제</title>
<link href="procss.css" rel="stylesheet" type="text/css">
</head>
<body>
<div>
	<ul>
		<li><a href="./">처음으로</a></li>
		<li><a href="inputFrm.jsp">제품 등록</a></li>
		<li><a href="./dataoutput">제품 정보 조회</a></li>
		<li><a href="searchFrm.jsp">제품 검색</a></li>
		<li><a href="updateFrm.jsp">제품 수정</a></li>
		<li><a href="deleteFrm.jsp" class="act">제품 삭제</a></li>
	</ul>
</div>
<div class="section">
<form action="./deletePro">
	<p>코드입력 : <input type="text" name="p_code"></p>
	<p><input type="submit" value="삭제"></p>
</form>
</div>
</body>
</html>