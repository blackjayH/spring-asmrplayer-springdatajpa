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
<link rel="stylesheet" type="text/css"
	href="${path}/resources/css/login.css">

<title>회원 정보 수정</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	// 수정 
	$(document).ready(function() {
		$("#btnUpdate").click(function() {
			if ($('#pw').val().length < 1)
				alert('페스워드 미입력');
			else if ($('#pw').val() != $('#pw2').val())
				alert('페스워드 확인해주세요');
			else {
				var id = $('#id').val();
				var pw = $('#pw').val();
				$.ajax({
					type : "PUT",
					data : JSON.stringify({
						id : id,
						pw : pw
					}),
					url : "${path}/user",
					contentType : 'application/json;charset=utf-8',
					dataType : 'json',
					success : function(response) {
						if (response.result == true)
							location.href = '${path}/'
						else
							alert('회원정보수정 실패');
					},
					error : function(error) {
						alert(error);
					}

				});
			}
		});
	});
	// 삭제
	$(document).ready(function() {
		$("#btnDelete").click(function() {
			if ($('#id').val().length < 1)
				alert('아이디 미입력');
			var id = $('#id').val();
			$.ajax({
				type : "DELETE",
				url : "${path}/user/" + id,
				success : function(response) {
					if (response.result == true)
						location.href = '${path}/v/login'
					else
						alert('삭제 실패');
				},
				error : function(error) {
					alert(error);
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
				<form name="form">
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
						<input type="button" id="btnDelete"
							class="btn btn-primary form-control" value="회원 정보 삭제">
					</div>
					<div class="form-group">
						<input type="button" id="btnUpdate"
							class="btn btn-primary form-control" value="회원 정보 수정">
					</div>
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
</body>
</html>