<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
</head>
<jsp:include page="/common/header.jsp"></jsp:include>
<h3>게시글 작성</h3>
번호 : <input type="text" name="seq" id="seq" ReadOnly value="${vo.seq }"><br>
작성자 : <input type="text" name="name" id="name" value="${vo.name}" ><br>
제목 : <input type="text" name="title" id="titld" value="${vo.title }"><br>
내용 : <input type="text area" name ="content" id="content" value="${vo.contents }"><br>
<button type="submit">수정완료</button>
	
<%@include file = "/common/footer.jsp" %>
</body>
</html>