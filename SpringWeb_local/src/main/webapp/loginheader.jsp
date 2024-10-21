<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
	pageContext.setAttribute("root", root);
	String id = (String)request.getSession().getAttribute("id");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="right">
	<%if(id != null) {%>
		login : <%=id %> <a href="<%=root %>/member.do?act=logout">logout</a>
	<% }else{ %>
		login : 로그인 되지 안았습니다
	<%} %>
	<a href="<%=root %>/">초기화면</a>
</div>
</body>
</html>