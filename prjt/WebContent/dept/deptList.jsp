<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>DeptList</title>
</head>
<jsp:include page="/common/header.jsp"></jsp:include>
	<h3>Department List</h3>
	<form name ="searchfrm">
	<input name="p" value ="1" type="hidden">
	부서명 검색 <select name ="department_name"><br>
	<option value="">부서목록
	<option value="10">Administration
	<option value="20">Marketing
	<option value="50">Shipping
	<option value="60">IT
	<option value="80">SALES
	</select>
	<button type="submit">검색</button>
	</form>
	<button><a href="DeptInsert.do?seq=${vo.department_id }">부서 추가</a></button>	
	<table border='1'>
	<tr align='center'>
	<td>부서번호</td>
	<td>부서명</td>
	<td>매니저 번호</td>
	<td>위치번호</td>
	<td colspan='2' >부서목록 관리</td>	
	</tr>
	<tr>
	<c:forEach items="${deptList }" var="vo"> 
	<td>${vo.department_id }</td>
	<td>${vo.department_name }</td>
	<td>${vo.manager_id }</td>
	<td>${vo.location_id }</td>
	<td><button><a href="DeptUpdate.do?seq=${vo.department_id }">부서 수정</a></button>
	<button><a href="DeptDelete.do?seq=${vo.department_id }">부서 삭제</a></button></td>
	</tr>
	</c:forEach>
	</table><br>
	<script>
	function gopage(p){
		document.searchfrm.p.value=p;
		document.searchfrm.submit();
	}
	</script>
	<my:paging paging="${paging }" jsfunc="gopage"/>
<%@include file = "/common/footer.jsp" %>
</body>
</html>