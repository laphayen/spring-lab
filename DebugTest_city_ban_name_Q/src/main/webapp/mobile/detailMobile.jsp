<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<div class="container p-4">

		<h2>핸드폰 상세 정보</h2>
		<a class="btn btn-warning"
			href="${root}/mobile?action=goUpdatePage&code=${mobile.code}">수정</a>
		<a class="btn btn-danger"
			href="${root}/mobile?action=delete&code=${mobile.code}">삭제</a>
		<table class="table table-striped">
			<tr>
				<td>고유번호</td>
				<td>${mobile.code}</td>
			</tr>
			<tr>
				<td>모델명</td>
				<td>${mobile.model}</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>${mobile.price}</td>
			</tr>
			<tr>
				<td>제조사</td>
				<td>${mobile.company}</td>
			</tr>
			<tr>
				<td>등록자</td>
				<td>${mobile.userId}</td>
			</tr>
		</table>

	</div>
	<%@ include file="/include/footer.jsp"%>