<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.edu.dto.*"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>	

<c:set var="root" value="${pageContext.request.contextPath }" />
	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세</title>

<script type="text/javascript">
	function deleteMember(){
		document.getElementById("memberform").action="${root}/member/memberdelete";
		document.getElementById("memberform").submit();
	}
	function updateMember(){
		document.getElementById("memberform").action="${root}/member/memberupdate";
		document.getElementById("memberform").submit();
	}
	
</script>
</head>
<body>
<jsp:include page="../loginheader.jsp"/>
	<div align="center">
		<h1>회원상세</h1>
		<form action="" method="post" id="memberform">
			<table border="1">
				<tr>
					<td>id</td>
					<td><input type="text" id="id" name="id" value="${m.id }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>pw</td>
					<td><input type="text" id="pw" name="pw" value="${m.pw }"></td>
				</tr>
				<tr>
					<td>name</td>
					<td><input type="text" id="name" name="name" value="${m.name }"></td>
				</tr>
				<tr>
					<td>age</td>
					<td><input type="text" id="age" name="age" value="${m.age }" %></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="수정" onclick="updateMember()"><input type="button" value="삭제" onclick="deleteMember()"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>