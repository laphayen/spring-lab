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
		<h2>회원정보 수정</h2>
		<form action="${pageContext.request.contextPath}/user" method="post">
			<input type="hidden" name="action" value="update">

			<div class="form-group">
				<label for="id">아이디:</label> <input type="text" class="form-control"
					id="id" name="id" value="${user.id}" readonly>
			</div>

			<div class="form-group">
				<label for="pw">새 비밀번호:</label> <input type="password"
					class="form-control" id="pw" name="pw" placeholder="새 비밀번호 입력"
					autocomplete="off">
			</div>

			<div class="form-group">
				<label for="pwConfirm">비밀번호 확인:</label> <input type="password"
					class="form-control" id="pwConfirm" name="pwConfirm"
					placeholder="새 비밀번호 확인" autocomplete="off">
			</div>

			<div class="form-group">
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name" name="name" value="${user.name}" required>
			</div>

			<div class="form-group">
				<label for="birthdate">생년월일:</label> <input type="date"
					class="form-control" id="birthdate" name="birthdate"
					value="${user.birthdate}" required>
			</div>

			<div class="form-group">
				<label for="phone">전화번호:</label> <input type="text"
					class="form-control" id="phone" name="phone"
					placeholder="010-0000-0000 형식으로 입력" required
					pattern="010-\d{4}-\d{4}"
					title="전화번호는 010-0000-0000 형식으로 입력해야 합니다." value="${user.phone }">
			</div>

			<div class="form-group">
				<label for="email">이메일:</label> <input type="email"
					class="form-control" id="email" name="email" value="${user.email}"
					required>
			</div>

			<br>

			<button type="submit" class="btn btn-primary">수정</button>
			<a class="btn btn-secondary"
				href="${pageContext.request.contextPath}">메인 페이지로</a>
		</form>
	</div>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>
