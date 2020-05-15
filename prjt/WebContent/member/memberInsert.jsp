<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Form Test</title>
<script>
	function validCheck() {
		//필수입력 체크
		if (frm.id.value == "") { //trim함수
			alert("id 입력");
			frm.id.focus(); /* 커서를 보냄. */
			return;
		}
		if (frm.pwd.value == "") {
			alert("pw 입력");
			frm.fwd.focus();
			return;
		}
		//체크박스
		/* hobby = document.getElementsByName("hobby")
		var cnt = 0;
		for (i = 0; i < hobby.length; i++) {
			if(hobby[i].checked == true)
		cnt++
		} */
		var cnt = document.querySeletorAll("[name=hobby]:checked");				 
		
		if(cnt == 0){
			alert("취미 1개이상 선택");
			return;
		//select
		}if(frm.religion.selectedIndex < 1){
			alert("종교 선택");
			return;
		}frm.submit();
		gender = document.getElementsByName("gender")
		var cnt1 = 0;
		for(i =0; i<gender.length; i++){
			if(gender[i].checked ==true)
				cnt1++
		}if(cnt1 ==0){
			alert("성별 선택")
			return;
		}
		
	}//end of validCheck
</script>
<%@include file="/common/header.jsp"%>
<body align="center">
	<!-- Navigation bar -->
	<h3>회원정보</h3>
	<form name="frm" action="MemberInsert.do" method="post">
		ID : <input type="text" name="id" id="id" /><br /> 비밀번호 : <input
			type="text" name="pwd" id="pwd"><br> 이름 : <input
			type="text" name="name" id="name"><br> 취미 : <input
			type="checkbox" name="hobby" value="h01" />등산 <input type="checkbox"
			name="hobby" value="h02" />운동 <input type="checkbox" name="hobby"
			value="h03" />독서 <input type="checkbox" name="hobby" value="h04" />여행<br>
		성별 : <input type="radio" name="gender" id="gender" value="m" />남자 <input
			type="radio" name="gender" value="f" />여자<br> 
			
			종교 : 
			<select	name="religion" id="religion">
			<option value="">--선택--
			<option value="r01">기독교
			<option value="r02">불교
			<option value="r03">천주교
			<option value="r04">무교
			</select>
		</select><br> 자기소개:<br>
		<textarea cols="30" rows="10" name="introduction" id="introduction"></textarea>
		<br>
		<button type="button" onclick="validCheck()">회원가입</button>
		<input type="reset" value="지우기">

	</form>

</body>

<%@include file="/common/footer.jsp"%>
</html>