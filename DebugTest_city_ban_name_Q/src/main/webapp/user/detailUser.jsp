<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />    
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보</title>
    <%@ include file="/include/head.jsp"%>
</head>
<body>
    <%@ include file="/include/nav.jsp"%>
    <div class="container p-4">
        <h2>회원 정보</h2>
        <form>
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text" class="form-control" id="id" name="id" value="${user.id}" readonly>
            </div>

            <div class="form-group">
                <label for="pw">비밀번호:</label>
                <input type="password" class="form-control" id="pw" name="pw" value="${user.pw}" readonly>
            </div>

            <div class="form-group">
                <label for="name">이름:</label>
                <input type="text" class="form-control" id="name" name="name" value="${user.name}" readonly>
            </div>

            <div class="form-group">
                <label for="birthdate">생년월일:</label>
                <input type="text" class="form-control" id="birthdate" name="birthdate" value="${user.birthdate}" readonly>
            </div>

            <div class="form-group">
                <label for="phone">전화번호:</label>
                <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}" readonly>
            </div>

            <div class="form-group">
                <label for="email">이메일:</label>
                <input type="email" class="form-control" id="email" name="email" value="${user.email}" readonly>
            </div>
            <br>
            <a class="btn btn-secondary" href="${root}">메인 페이지로</a>
            <a class="btn btn-primary" href="${root}/user?action=goUpdatePage">회원정보 수정</a>
        </form>
    </div>
    <%@ include file="/include/footer.jsp"%>
</body>
</html>
