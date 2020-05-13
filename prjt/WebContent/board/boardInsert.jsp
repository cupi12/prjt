<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
</head>
<jsp:include page="/common/header.jsp"></jsp:include>
<h3>게시글 작성</h3>
<form action="../BoardInsert.do" method="post">
작성자 : <input type="text" name="id" id="id" readonly value="${sessionScope.loginId }"><br>
제목 : <input type="text" name="title" id="titld" ><br>
내용 : <textarea name ="contents" id="contents"></textarea><br>
<input type="submit" value="글쓰기"><input type="reset" value="지우기">
</form>
<%@include file = "/common/footer.jsp" %>
</body>
</html>