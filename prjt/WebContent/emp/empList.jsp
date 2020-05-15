<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
	<h3>사원목록</h3>
	<form name="searchfrm">
	<input name="p" value="1" type="hidden">
	Search department<select name="department_id"><br>	
	<option value="">전체
	<option value="10">Administration
	<option value="20">Marketing
	<option value="50">Shipping
	</select>
	이름<input name="first_name">
	<button type="submit">검색</button>
	</form>
	<a href="EmpInsert.do">사원등록</a>
	<table border="1">
		<tr>
			<th>사번</th>
			<th>이름</th>
		</tr>
		<c:forEach items="${list }" var="vo">
			<tr>
				<td>${vo.employee_id }</td>
				<td>${vo.first_name } ${vo.last_name }</td>
			</tr>
		</c:forEach>
	</table>
	<script>
	function gopage(p){
		document.searchfrm.p.value = p;
		document.searchfrm.submit();
	}
	</script>
	<my:paging paging="${paging }" jsfunc="gopage"/>
	<%@include file = "/common/footer.jsp" %>
</body>
</html>