
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
<title>asmr player</title>
</head>
<body bgcolor="black">
	<!--  이하 각 재생 버튼 아이콘들   -->
	<!--  play(x)로 이벤트 연결 x가 10의 배수인 이유는 나중에 벌레소리(10) 벌레소리2(11)등으로 분류하기 위해 -->

	<!-- 각 소리당 재생은 1개씩만 하므로 볼륨슬라이더는 10개만 할당  -->
	<!-- /1.비 /10.벌레 /20.바람 /30.번개 /40.끓는소리 /50.새 /60.불 /70.파도 /80.사람 /90.TV -->

	<audio id="audio0" loop="loop" preload="auto"> <source
		src='${path}/resources/mp4/main-rain.ogg' type="audio/ogg" /> <source
		src='${path}/resources/mp4/main-rain.mp4' type="audio/mpeg" />
	<p>죄송합니다. 지금 사용하고 계신 브라우저가 audio 태그를 지원하지 않습니다.</p>
	</audio>


	<audio id="audio1" loop="loop" preload="auto"> <source
		src='${path}/resources/mp4/main-crickets.mp4' type="audio/mpeg" /> <source
		src='${path}/resources/mp4/main-crickets.ogg' type="audio/ogg" />
	<p>죄송합니다. 지금 사용하고 계신 브라우저가 audio 태그를 지원하지 않습니다.</p>
	</audio>

	<audio id="audio2" loop="loop" preload="auto"> <source
		src='${path}/resources/mp4/main-wind.mp4' type="audio/mpeg" /> <source
		src='${path}/resources/mp4/main-wind.ogg' type="audio/ogg" />
	<p>죄송합니다. 지금 사용하고 계신 브라우저가 audio 태그를 지원하지 않습니다.</p>
	</audio>

	<audio id="audio3" loop="loop" preload="auto"> <source
		src='${path}/resources/mp4/main-thunder.mp4' type="audio/mpeg" /> <source
		src='${path}/resources/mp4/main-thunder.ogg' type="audio/ogg" />
	<p>죄송합니다. 지금 사용하고 계신 브라우저가 audio 태그를 지원하지 않습니다.</p>
	</audio>

	<audio id="audio4" loop="loop" preload="auto"> <source
		src='${path}/resources/mp4/main-sbowl.mp4' type="audio/mpeg" /> <source
		src='${path}/resources/mp4/main-sbowl.ogg' type="audio/ogg" />
	<p>죄송합니다. 지금 사용하고 계신 브라우저가 audio 태그를 지원하지 않습니다.</p>
	</audio>

	<audio id="audio5" loop="loop" preload="auto"> <source
		src='${path}/resources/mp4/main-birds.mp4' type="audio/mpeg" /> <source
		src='${path}/resources/mp4/main-birds.ogg' type="audio/ogg" />
	<p>죄송합니다. 지금 사용하고 계신 브라우저가 audio 태그를 지원하지 않습니다.</p>
	</audio>

	<audio id="audio6" loop="loop" preload="auto"> <source
		src='${path}/resources/mp4/main-fire.mp4' type="audio/mpeg" /> <source
		src='${path}/resources/mp4/main-fire.ogg' type="audio/ogg" />
	<p>죄송합니다. 지금 사용하고 계신 브라우저가 audio 태그를 지원하지 않습니다.</p>
	</audio>

	<audio id="audio7" loop="loop" preload="auto"> <source
		src='${path}/resources/mp4/main-waves.mp4' type="audio/mpeg" /> <source
		src='${path}/resources/mp4/main-waves.ogg' type="audio/ogg" />
	<p>죄송합니다. 지금 사용하고 계신 브라우저가 audio 태그를 지원하지 않습니다.</p>
	</audio>

	<audio id="audio8" loop="loop" preload="auto"> <source
		src='${path}/resources/mp4/main-people.mp4' type="audio/mpeg" /> <source
		src='${path}/resources/mp4/main-people.ogg' type="audio/ogg" />
	<p>죄송합니다. 지금 사용하고 계신 브라우저가 audio 태그를 지원하지 않습니다.</p>
	</audio>

	<audio id="audio9" loop="loop" preload="auto"> <source
		src='${path}/resources/mp4/main-tv.mp4' type="audio/mpeg" /> <source
		src='${path}/resources/mp4/main-tv.ogg' type="audio/ogg" />
	<p>죄송합니다. 지금 사용하고 계신 브라우저가 audio 태그를 지원하지 않습니다.</p>
	</audio>

	</div>

	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.1.0.min.js"></script>
	<script type="text/javascript">
		var AudioFlag = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]; //11번째는 AllPlay제어용 음원을 분류하여 나중에 Ajax로 보냄
		var playnum = 0; // 현재 재생되고 있는 음원 수
		var timerID; // 타이머용 전역변수
		var sec = 0; // 타이머용 초

		function sleep(seconds) {
			var waitUntil = new Date().getTime() + seconds;
			while (new Date().getTime() < waitUntil)
				true;
		}

		function testing() {
			var aud = document.getElementById("audio1");
			alert(aud.src);
			aud.pause();
			aud.src = '${path}/resources/audio/main-tv.mp4'; // 테스트
			alert(aud.src);
			aud.load();
			aud.play();
		}
		// 개별 mp4파일 재생
		function play(num, menu) { //////// num에 해당하는 mp4파일을 가져와서 재생.
			var audio_num = parseInt(num / 10);
			var aud = document.getElementById("audio" + audio_num);
			var src = null;
			src = "${path}/resources/audio/" + num + ".mp4";
			aud.src = src;
			if (AudioFlag[audio_num] != num) {
				if (AudioFlag[audio_num] == 0)
					playnum++;
				if (AudioFlag[10] == 0)
					pauseall();
				aud.pause();
				aud.load();
				aud.play();
				AudioFlag[audio_num] = num;
				add(menu);
			} else {
				remove(menu);
				aud.pause();
				playnum--;
				if (playnum == 0) {
					var all = document.getElementById("play_icon");
					all.src = '${path}/resources/image/play.png';
					AudioFlag[10] = 0;
				}
				AudioFlag[audio_num] = 0;
			}
		}

		// 음량 선택
		function setvolume(num) {
			var aud = document.getElementById("audio" + num);
			var vol = document.getElementById("volumeslider" + num);
			aud.volume = vol.value / 10;
		}

		// 전체 일시 정지/재생
		function pauseall() {
			if (playnum == 0)
				alert('음악을 선택해주세요');
			if (AudioFlag[10] == 0 && playnum != 0) {
				AudioFlag[10] = 1;
				var all = document.getElementById("play_icon");
				all.src = '${path}/resources/image/pause.png';
				for (var i = 0; i < 10; i++) {
					if (AudioFlag[i] != 0) {
						var aud = document.getElementById("audio" + i);
						aud.play();
					}
				}
			} else {
				AudioFlag[10] = 0;
				var all = document.getElementById("play_icon");
				all.src = '${path}/resources/image/play.png';
				for (var i = 0; i < 10; i++) {
					var aud = document.getElementById("audio" + i);
					aud.pause();
				}
			}
		}

		// 현재 재생 목록 리셋
		function reset() {
			for (var i = 0; i < 10; i++) {
				var aud = document.getElementById("audio" + i);
				var vol = document.getElementById("volumeslider" + i);
				aud.pause();
				aud.volume = 1;
				AudioFlag[i] = 0;
				remove(".menu" + (i + 1));
				vol.value = 100;
			}
			var all = document.getElementById("play_icon");
			all.src = '${path}/resources/image/play.png';
			AudioFlag[10] = 0;
			playnum = 0;
		}

		// 재생 목록 저장
		function ajaxSave() {
			var ArrayData = new Array();
			var slot = $('[name="Slot"]').val();
			if (!slot)
				alert('저장 슬롯을 선택해주세요');
			if (slot == 1 || slot == 2 || slot == 3) {
				for (var i = 0; i < 10; i++) {
					var aud = document.getElementById("audio" + i);
					var Data = new Object();
					Data.userid = '<c:out value="${id}"/>';
					;
					Data.musicnumber = i;
					Data.track = AudioFlag[i];
					Data.volume = aud.volume;
					Data.slot = slot;
					ArrayData.push(Data);
				}
				$.ajax({
					type : 'POST',
					data : JSON.stringify(ArrayData),
					url : "${path}/audio",
					contentType : 'application/json;charset=utf-8',
					dataType : 'json',
					success : function(response) {
						if (response.result == true)
							alert(slot + "번째 슬롯에 저장되었습니다.");
						else
							alert('저장 실패');
					},
					error : function(error) {
						alert(error);
					}
				});
			}
		}

		// 재생 목록 로드
		function ajaxLoad() {
			var slot = $('[name="Slot"]').val();
			if (!slot)
				alert('슬롯을 선택해주세요');
			if (slot == 1 || slot == 2 || slot == 3) {
				$.ajax({
					type : "GET",
					url : "${path}/audio/" + slot,
					success : function(response) {
						if (response.result == true) {
							reset();
							var ar = response.playList;
							if (ar.length == 0)
								alert('해당 슬롯에는 저장된 목록이 없습니다');
							for (var i = 0; i < ar.length; i++) {
								if (ar[i].track != 0) {
									var track = parseInt(ar[i].track / 10);
									var aud = document.getElementById("audio"
											+ track);
									var vol = document
											.getElementById("volumeslider"
													+ track);
									var volume = ar[i].volume;
									play(ar[i].track, (".menu" + (i + 1)));
									aud.volume = volume;
									vol.value = volume * 10;
								}
							}
						}
						else
							alert('로드 실패');
					},
					error : function(error) {
						alert(error);
					}
				});
			}
		}

		/*사이드바 플레이목록 추가 삭제*/
		function add(menu) {
			$(menu).show("slow");
		}

		function remove(menu) {
			$(menu).hide("slow");
		}

		/*아이콘에 마우스 오버 시 오디오 리스트 보임 */
		function hide_list(sub_list) {
			var sublist = $(sub_list);
			if (sublist.is(":visible")) {
				sublist.slideUp();
			} else {
				sublist.slideDown();
			}
		}

		/*전체화면이 아닐때 로그인 버튼 숨기기*/
		$(window).resize(function() {
			var windowWidth_ = $(window).width();
			if (windowWidth_ / screen.width < 0.95) {
				$('login').hide("slow");
			} else {
				$('login').show("slow");
			}
		});

		// 타이머 셋팅
		function timer() {
			timerID = setInterval("decrementTime()", 1000);
			var form = document.getElementById('t_field');
			form.style.display = "";
			var form2 = document.getElementById('t_setting');
			form2.style.display = "none";
		}

		// 타이머 시작
		function decrementTime() {
			var x1 = document.getElementById("t_time");
			var x2 = document.getElementById("t_min");
			if (sec == 0) {
				if (x2.value == 0) {
					if (x1.value == 0) {
						if (AudioFlag[10] != 0)
							playall()
						resettimer();
					} else {
						x1.value = x1.value - 1;
						x2.value = 59;
					}
				} else {
					x2.value = x2.value - 1;
					sec = 59;
				}
			} else
				sec--;
			$('.t_field').text(x1.value + "시간 " + x2.value + "분 " + sec);
		}

		// 타이머 정지
		function stoptimer() {
			clearInterval(timerID);
		}

		// 타이머 리셋
		function resettimer() {
			clearInterval(timerID);
			var x1 = document.getElementById("t_time");
			var x2 = document.getElementById("t_min");
			var form = document.getElementById('t_field');
			form.style.display = "none";
			var form2 = document.getElementById('t_setting');
			form2.style.display = "";
			x1.value = "";
			x2.value = "";
			sec = 0;
		}
	</script>
</body>