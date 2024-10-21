<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원입력</title>
</head>
<body>
<jsp:include page="/loginheader.jsp"/>
	<div align="center">
		<h1>회원입력</h1>
		<form action="<%=root %>/member/memberinsert" method="post">
			<table border="1">
				<tr>
					<td>id</td>
					<td><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<td>pw</td>
					<td><input type="text" id="pw" name="pw"></td>
				</tr>
				<tr>
					<td>name</td>
					<td><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
					<td>age</td>
					<td><input type="text" id="age" name="age"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="입력"><input type="reset" value="취소"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>