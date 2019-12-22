<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jstl 시간 출력 태그 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- context 경로 -->
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet'
	href='http://fonts.googleapis.com/earlyaccess/nanumpenscript.css'>
<link rel="stylesheet" type="text/css"
	href="${path}/resources/css/login.css">

<title>회원가입</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.1.0.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		var flag = false; // ID 중복 체크 여부 변수
		// ID 중복체크 액션 GET
		$(document).ready(function() {
			$("#btnCheck").click(function() {
				if ($('#id').val().length < 1) 
					alert('아이디 미입력');
				var id = $('#id').val();
				$.ajax({
					type : "GET",
					//data : id,
					url : "${path}/user/" + id,
					success : function(response) {
						if(response.result == true)
							alert('18');
						else
							alert('실패');	
					},
					error : function(error) {
						alert(error);
					}
				});
			});
		});
		// 회원가입 액션 POST
		$(document).ready(function() {
			$("#btnSubmit").click(function() {
				//if ($('#pw').val().length < 1)
				//	alert('페스워드 미입력');
				//else if ($('#pw').val() != $('#pw2').val())
				//	alert('페스워드 확인해주세요');
				//else {
					var id = $('#id').val();
					var pw = $('#pw').val();
					$.ajax({
						type : "POST",
						data : JSON.stringify({
							id : id,
							pw : pw
						}),
						url : "${path}/user",
						contentType : 'application/json;charset=utf-8',
						dataType : 'json',
						success : function(response) {
							if(response.result == true)
								alert('성공');
							else
								alert('실패');						
						},
						error : function(error) {
							alert(error);
						}

					});			
				//}
			});
		});
	</script>
</head>
<body>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
				<form name="form2" >
					<h3 style="text-align: center;">회원가입 화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디" id="id"
							name="id" maxlength="20">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호"
							id="pw" name="pw" maxlength="20">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호확인"
							id="pw2" name="pw2" maxlength="20">
					</div>
					<div class="form-group">
						<input type="button" id="btnCheck"
							class="btn btn-primary form-control" value="아이디 중복 체크">
					</div>
					<div class="form-group">
						<input type="button" id="btnSubmit"
							class="btn btn-primary form-control" value="회원가입">
					</div>
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>

	
</body>
</html>