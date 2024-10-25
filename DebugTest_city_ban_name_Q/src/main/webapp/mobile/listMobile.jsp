<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- @@DELETE CODE :  --%>
<%@ include file="/include/head.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
		<h2>핸드폰 목록</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>고유번호</th>
					<th>모델명</th>
					<th>가격</th>
					<th>제조사</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="mobile" items="${mobileList}">
					<tr>
						<td>${mobile.code}</td>
						<td><a
							href="${root}/mobile?action=detail&code=${mobile.code}">${mobile.model}</a></td>
						<td>${mobile.price}</td>
						<td>${mobile.company}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<%@ include file="/include/footer.jsp"%>