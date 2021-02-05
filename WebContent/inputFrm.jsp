<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 등록</title>
<link href="procss.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<ul>
			<li><a href="./">처음으로</a></li>
			<li><a href="inputFrm.jsp" class="act">제품 등록</a></li>
			<li><a href="./dataoutput">제품 정보 조회</a></li>
			<li><a href="searchFrm.jsp">제품 검색</a></li>
			<li><a href="updateFrm.jsp">제품 수정</a></li>
			<li><a href="deleteFrm.jsp">제품 삭제</a></li>
		</ul>
	</div>
	<div class="section">
		<form action="inproc.jsp" method="post">
			<table>
				<tr>
					<th width="100">제품코드</th>
					<td width="200"><input type="text" name="p_code" required>
					</td>
				</tr>
				<tr>
					<th>제품명</th>
					<td><input type="text" name="p_name" required></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="number" name="p_price" required></td>
				</tr>
				<tr>
					<th>제품유형</th>
					<td><input type="text" name="p_type" required></td>
				</tr>
				<tr>
					<th>수량</th>
					<td><input type="number" name="p_amount"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center;"><input type="submit" value="등록"></td>
					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>