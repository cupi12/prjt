<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
<jsp:include page="/common/header.jsp"></jsp:include>
<h3>회원관리</h3>
<br>
<form name="searchMember">
<input name="p" value="1" type="hidden">
	회원검색<input name="name">
	<button type="submit">검색</button>
</form>
<table border=1>
	<tr>
		<td>id</td>
		<td>name</td>
	</tr>
	<c:forEach items="${list }" var="vo">
		<tr>
			<td>${vo.id }</td>
			<td>${vo.name }</td>
		</tr>
	</c:forEach>
</table>
<script>
	function gopage(p) {
		document.searchMember.p.value = p;
		document.searchMember.submit();
	}
</script>
<my:paging paging="${paging }" jsfunc="gopage" />
<%@include file="/common/footer.jsp"%>
</body>
</html>