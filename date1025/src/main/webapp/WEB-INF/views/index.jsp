<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="./loginheader.jsp"/>
<div align="center">
	<a href="${root }/member/memberselectall">회원전체조회</a><br>
	<a href="${root }/member/memberinsertform">회원입력</a><br>
	<a href="${root }/member/loginform">로그인</a><br>
	<a href="${root }/file/list">저장파일보기</a><br>
	
	<h1>파일업로드</h1>
	<form action="${root}/file/fileupload" method="post" enctype="multipart/form-data">
		파일 : <input type="file" name="upfile" multiple="multiple">
		<input type="submit" value="업로드">
	</form>
	<c:if test="${!empty list }">
		<h1>파일 다운로드</h1>
		<table border="1">
		<tr><td>파일이름</td></tr>
		<c:forEach items="${list }" var="dto">
			<tr><td><a href="${root }/file/download?saveFile=${dto.saveFile }">${dto.originalFile }</a></td></tr>
		</c:forEach>	
		</table>
	</c:if>
</div>
</body>
</html>