<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link"
			href="${root}/">메인</a></li>
		<li class="nav-item"><a class="nav-link"
			href="${root}/mobile?action=list">핸드폰 목록</a></li>
		<li class="nav-item"><a class="nav-link"
			href="${root}/mobile?action=goRegistPage">핸드폰 정보 등록</a></li>
	</ul>
	<c:choose>
		<c:when test="${empty userInfo}">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="${root}/user?action=goLoginPage">로그인</a></li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="${root }/user?action=goDetailPage">${userInfo.name}님 반갑습니다.</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${root}/user?action=logout">로그아웃</a></li>
			</ul>
		</c:otherwise>
	</c:choose>
</nav>