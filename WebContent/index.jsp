<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작 페이지</title>
<link href="procss.css" rel="stylesheet" type="text/css">
</head>
<body>
<div>
	<ul>
		<li><a href="./" class="act">처음으로</a></li>
		<li><a href="inputFrm.jsp">제품 등록</a></li>
		<li><a href="./dataoutput">제품 정보 조회</a></li>
		<li><a href="searchFrm.jsp">제품 검색</a></li>
		<li><a href="updateFrm.jsp">제품 수정</a></li>
		<li><a href="deleteFrm.jsp">제품 삭제</a></li>
	</ul>
</div>


<div class="section">
<h1>제품관리 프로그램 ver.1</h1>
<c:if test="${!empty msg}">
	<script type="text/javascript">
		alert('${msg}');
	</script>
	<c:remove var="msg" scope="session"/>
</c:if>
</div>
</body>
</html>