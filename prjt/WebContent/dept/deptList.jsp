<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>DeptList</title>
</head>
<jsp:include page="/common/header.jsp"></jsp:include>
	<h3>Department List</h3>
	<table border='1'>
	<tr>
	<td>부서번호</td>
	<td>부서명</td>
	<td>매니저 번호</td>
	<td>위치번호</td>	
	</tr>
	<tr>
	<c:forEach items="${deptList }" var="vo"> 
	<td>${vo.department_id }</td>
	<td>${vo.department_name }</td>
	<td>${vo.manager_id }</td>
	<td>${vo.location_id }</td>
	</tr>
	</c:forEach>
	</table><br>
	<a href="DeptInsert.do">부서 추가</a><br>
	<a href="DeptUpdate.do">부서 수정</a>
<%@include file = "/common/footer.jsp" %>
</body>
</html>