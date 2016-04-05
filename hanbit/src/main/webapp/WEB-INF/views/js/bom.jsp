<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container" style="width: 1000px; margin: 0 auto;"> <!-- container -> 부트스트랩에서 이미 선언되어있는 클래스  -->
	<div>
		<h3>브라우저 객체 BOM</h3>
		<h4>Window 객체</h4> <!-- 팝업 띄울 떄 많이 씀 -->
		<ul>
			<li>[1] 대화창
				<ul>
					<li><a href="#" onclick="javascript:win.alert()">경고창</a></li><!-- #은 해당 페이지라는 의미이다. --> <!-- javascript:win.alert() 이렇게 써도되고 win.alert() 이렇게 써도된다.  -->
					<li><a href="#" onclick="javascript:win.confirm()">확인창</a></li>
					<li><a href="#" onclick="javascript:win.prompt()">입력창</a></li>
				</ul>
			</li>
			<li>[2] 팝업창
				<ul>
					<li>open('문서명','창이름','속성') : 
						<a href="#" onclick="win.open()">새 창 열기</a>
					</li>
					<li>
						close() : 창 닫기
					</li>
				</ul>
			</li>
		</ul>
		<h4>history 객체</h4> <!-- 앞으로 가기, 뒤로 가기  -->
		<ul>
			<li><a href="#" onclick="win.f5()">새로고침</a></li>
			<li><a href="#" onclick="win.goBack()">이전페이지</a></li>
		</ul>
		<h4>location 객체</h4> 
		<ul>
			<li><a href="#" onclick="win.href()">홈으로 이동</a></li>
		</ul>
	</div>
</div>
<script type="text/javascript">
	var win = {
			alert : function() {
				alert('경고창은 메시지만 전달');
			}, /* , 쉼표로 함수와 함수 사이를 구분한다. */
			confirm : function() {
				confirm('컨펌창은 확인/취소 버튼이 존재한다.');
			},
			prompt : function() {
				prompt('프롬프트창은 값을 입력하는 것이 가능하다 (단, 스트링 값으로만 인식되므로 숫자를 입력받으면 형변환해줘야한다.)');
			},
			open : function() { // URL을 설정하여 호출이 가능하다.
				window.open('${context}/member/login_form.do');
			},
			href : function() { // URL을 설정하여 호출이 가능하다.
				location.href = '${context}/global/main.do';
			},
			f5 : function() { // 새로고침
				history.go(0);
			},
			goBack : function() { // 뒤로가기
				history.go(-1);
			}
	}
</script>