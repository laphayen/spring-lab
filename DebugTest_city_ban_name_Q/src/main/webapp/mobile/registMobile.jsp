<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>
	<div class="container p-4">

		<h2>핸드폰 정보 등록</h2>
		<form id="registForm" action="${root}/mobile" method="post">
			<input type="hidden" name="action" value="regist">
			<div class="form-group">
				<label for="code">고유번호</label> <input type="text"
					class="form-control" id="code" name="code" placeholder="고유번호 입력">
			</div>
			<div class="form-group">
				<label for="model">모델명</label> <input type="text"
					class="form-control" id="model" name="model" placeholder="모델명 입력">
			</div>
			<div class="form-group">
				<label for="price">가격</label> <input type="number"
					class="form-control" id="price" name="price" placeholder="가격 입력">
			</div>
			<div class="form-group">
				<label for="company">제조사</label> <input type="text"
					class="form-control" id="company" name="company" placeholder="제조사 입력">
			</div>

			<button type="submit" class="btn btn-primary" id="regist">등록</button>
			<a class="btn btn-secondary" href="${root}/mobile?action=list">취소</a>
		</form>


	</div>
	<%@ include file="/include/footer.jsp"%>