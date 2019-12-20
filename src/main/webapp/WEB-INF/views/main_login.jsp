<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jstl 시간 출력 태그 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- context 경로 -->
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta http-equiv="Content-Type" Content="text/html; charset=utf-8" />

<link rel='stylesheet'
	href='http://fonts.googleapis.com/earlyaccess/nanumpenscript.css'>
<link rel="stylesheet" type="text/css" href="${path}/resources/css/login.css">

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script>
//회원가입 액션 POST
$(document).ready(function() {
	$("#btnSubmit").click(function() {
		var form = {
			id : $('#id').val(),
			pw : $('#pw').val()
		};
		$.ajax({
			type : "POST",
			data : form,
			url : "${path}/user/jpa/add",
			success : function(data) {
				if (data.result == true) {
					location.href = '${path}/'
				}
				
			},
			error : function(error) {
				alert(error);
			}
		});
	});
});
</script>
<title>로그인</title>
</head>

<body>

	<h2>회원등록</h2>
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td>아이디</td>
				<td><input id="id" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="pw" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button"
					value="아이디 중복 체크" id="btnSubmit"> 
					<input type="button"
					value="리셋" id="btnReset">  
					<input type="submit" value="가입"> <input
					type="reset" value="취소">
			</tr>
		</table>
	</form>
</body>
</html>