<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 수량 수정</title>
<link href="procss.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<ul>
			<li><a href="./">처음으로</a></li>
			<li><a href="inputFrm.jsp">제품 등록</a></li>
			<li><a href="./dataoutput">제품 정보 조회</a></li>
			<li><a href="searchFrm.jsp">제품 검색</a></li>
			<li><a href="updateFrm.jsp" class="act">제품 수정</a></li>
			<li><a href="deleteFrm.jsp">제품 삭제</a></li>
		</ul>
	</div>
	<div class="section">
		<form action="./dataupdate">
			<p>
				제품코드 입력 : <input type="text" name="p_code">
			</p>
			<p>
				<input type="submit" value="검색">
			</p>
		</form>
				<c:if test="${!empty upData}">
			<form action="upproc.jsp" method="post">
				<table>
					<tr>
						<th width="100">제품코드</th>
						<td width="200"><input type="text" name="p_code"
							value="${upData.p_code}" readonly></td>
					</tr>
					<tr>
						<th>제품명</th>
						<td><input type="text" name="p_name" value="${upData.p_name}">
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="text" name="p_price"
							value="${upData.p_price}"></td>
					</tr>
					<tr>
						<th>제품 유형</th>
						<td><input type="text" name="p_type" value="${upData.p_type}">
						</td>
					</tr>
					<tr>
						<th>수량</th>
						<td><input type="text" name="p_amount"
							value="${upData.p_amount}"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="전송"></td>
					</tr>
				</table>
			</form>
		</c:if>
	</div>
</body>
</html>