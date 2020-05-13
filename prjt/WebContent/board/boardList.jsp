<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<jsp:include page="/common/header.jsp"></jsp:include>
	<h3>게시글 목록</h3>
	<table border="1">
	<tr>
	<td>번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>작성일자</td>
		</tr>
		<c:forEach items="${boardList }" var="vo">
		<tr>
		<td>${vo.seq }</td>
		<td>${vo.title }</td>
		</a><td><a href="BoardUpdate.do?seq=${vo.seq }">${vo.contents}</a></td>
		<td>${vo.name }</td>		
		<td>
		<fmt:parseDate value="${vo.regdt }" var="fmtDt" pattern="yyyy-MM-dd HH:mm:ss"/>
		<fmt:formatDate value="${fmtDt}" type="both"/></td>
		</tr>
		</c:forEach>
		</tr>
	</table>
	<%@include file = "/common/footer.jsp" %>
</body>
</html>