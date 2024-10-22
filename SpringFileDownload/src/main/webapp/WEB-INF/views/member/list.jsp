<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.ssafy.edu.dto.*"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>	
<c:set var="root" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<script type="text/javascript">
	function dels(){
		let dels =  document.getElementsByName("dels");
		let params = "";
		for(let del of dels){
			if(del.checked){
				params += "id="+del.value+"&";
			}
		}
		location.href = "${root}/member/dels?"+params;
	}
</script>
</head>
<body>
	<%-- <%@ include file="/loginheader.jsp" %> --%>
	<jsp:include page="../loginheader.jsp"></jsp:include>
	<div align="center">
		<h1>회원조회</h1>
		<table border="1">
			<tr>
				<td>id</td>
				<td>pw</td>
				<td>name</td>
				<td>age</td>
				<td></td>
			</tr>
			
			<c:forEach items="${list }" var="m">
				<tr>
					<td><a href="${root }/member/memberdetail?id=${m.id}">${m.id}</a></td>
					<td>${m.pw}</td>
					<td>${m.name}</td>
					<td>${m.name}</td>
					<td><input type="checkbox" name="dels" value="${m.id}"></td>
				</tr>
			</c:forEach>
			
			<tr ><td colspan="5"><input type="button" value="선택삭제" onclick="dels()"></td></tr>
		</table>
	</div>
</body>
</html>