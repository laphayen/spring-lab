<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//String root = request.getContextPath();
	String root1 = request.getContextPath();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/loginheader.jsp" %>
<div align="center">
	<a href="<%=root1%>/member/memberselectall">회원전체조회</a><br>
	<a href="<%=root1%>/member/memberinsertform">회원입력</a><br>
	<a href="<%=root1%>/member/loginform">로그인</a><br>
	</div>
</body>
</html>