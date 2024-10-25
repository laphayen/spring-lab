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
<div align="right">
	
	<c:choose>
		<c:when test="${!empty id }">
			login : ${id } <a href="${root }/member/logout">logout</a>
		</c:when>
		<c:otherwise>
			login : 로그인 되지 안았습니다
		</c:otherwise>
	</c:choose>
		
	<a href="${root }/">초기화면</a>
</div>
</body>
</html>