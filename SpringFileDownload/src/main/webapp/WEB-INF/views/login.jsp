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
<%
Cookie[] cookies = request.getCookies();
String id = new String();
if(cookies != null){
	for (Cookie c : cookies) {
		if(c.getName().equals("idsave")){
			id = c.getValue();
			request.setAttribute("id", id);
			break;
		}
	}
}
%>
<body>
	<div align="center">
		<form action="${root }/member/login" method="post">
			<h1>로그인</h1>
			<table border="1">
				<tr>
					<td>id</td>
					<td><input type="text" name="id" value="${id }"><input type="checkbox" name="idsave" id="idsave" ${id.length()>0?"checked":""  }></td>
				</tr>
				<tr>
					<td>pw</td>
					<td><input type="text" name="pw"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>