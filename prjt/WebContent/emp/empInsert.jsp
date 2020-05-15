<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>사원등록</title>
<script>
function validCheck(){
if(frm.employee_id.value==""){
	alert("id입력");
	frm.employee_id.focus();
	}if(frm.first_name.value==""){
		alert("first_name입력");
		frm.employee_id.focus();
		}if(frm.job_id.value==""){
			alert("job_id입력");
			frm.employee_id.focus();
			}
}
</script>
</head>
<%@include file="/common/header.jsp"%>
<h3>사원등록</h3>
<form name="frm" action="EmpInsert.do" method="post">
employee_id<input type="text" id="employee_id" name="employee_id"><br>
first_name<input type="text" id="first_name" name="first_name"><br>
last_name<input type="text" id="last_name" name="last_name"><br>
email<input type="text" id="email" name="email"><br>
phone_number<input type="text" id="phone_number" name="phone_number"><br>
hire_date<input type="text" id="hire_date" name="hire_date"><br>
job_id<input type="text" id="job_id" name="job_id"><br>
<button type="button" onclick="validCheck()">사원등록</button>
<input type="reset" value="지우기">
</form>
<%@include file="/common/footer.jsp"%>
</body>
</html>