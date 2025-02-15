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
		<h2>로그인</h2>
		<form action="${root}/user" method="post">
			<input type="hidden" name="action" value="login">
			<div class="form-group">
				<label for="id">id:</label> <input type="text" class="form-control"
					id="id" name="id" placeholder="ID 입력"
					value="${cookie.savedId != null ? cookie.savedId.value : ''}">
			</div>
			<div class="form-group">
				<label for="pw">Password:</label> <input type="password"
					class="form-control" id="pw" name="pw" placeholder="비밀번호 입력">
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> 
				<input class="form-check-input" type="checkbox" name="remember">
					아이디 기억하기
				</label>
			</div>
			<button type="submit" class="btn btn-primary">로그인</button>
			<a class="btn btn-warning" href="${root}/user?action=goRegistPage">회원가입</a>
			<a class="btn btn-secondary" href="${root}">메인 페이지로</a>
		</form>
	</div>
	<%@ include file="/include/footer.jsp"%>