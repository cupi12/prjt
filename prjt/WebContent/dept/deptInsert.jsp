<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<h3>부서등록</h3>
<form action="DeptInsert.do" method="post">
department_id : <input type="text" name="department_id" ><br>
department_name : <input type="text" name="department_name"><br>
manager_id : <input type="text" name="manager_id"><br>
location_id<input type="text" name ="location_id"><br>
<input type="submit" value="등록"><input type="reset" value="지우기">
</form>
<%@include file = "/common/footer.jsp" %>
</body>
</html>