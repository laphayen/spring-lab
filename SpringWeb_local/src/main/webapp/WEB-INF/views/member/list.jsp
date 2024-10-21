<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.ssafy.edu.dto.*"%>

<%
String root = request.getContextPath();
List<MemberDto> list = (List<MemberDto>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<script type="text/javascript">
function dels() {
    let list = document.getElementsByName("dels");
    let params = new URLSearchParams();
    for (let del of list) {
        if (del.checked) {
            params.append("id", del.value);
        }
    }

    fetch('<%=root%>/member/dels', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: params
    }).then(response => {
        if (response.ok) {
        	 window.location.reload();
        } else {
            console.error('Failed to delete members');
        }
    }).catch(error => {
        console.error('Error:', error);
    });
}

</script>
</head>
<body>
	<%-- <%@ include file="/loginheader.jsp" %> --%>
	<jsp:include page="/loginheader.jsp"></jsp:include>
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
			<%
			for (MemberDto m : list) {
			%>
			<tr>
				<td><a href="<%=root%>/member/detail?id=<%=m.getId()%>"><%=m.getId()%></a></td>
				<td><%=m.getPw()%></td>
				<td><%=m.getName()%></td>
				<td><%=m.getAge()%></td>
				<td><input type="checkbox" name="dels" value=<%=m.getId()%>></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td colspan="5"><input type="button" value="선택삭제"
					onclick="dels()"></td>
			</tr>
		</table>
	</div>
</body>
</html>