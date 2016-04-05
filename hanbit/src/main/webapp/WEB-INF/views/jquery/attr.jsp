<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container" style="width: 1000px; margin: 0 auto;">
	<button id="callImg">이미지 불러오기</button>
	<button id="htmlDemo">html() 테스트</button>
	<button id="textDemo">text() 테스트</button>
	<div id="sampleBox1" style="border: 1px solid black; width: 300px; height: 300px;"> <!-- solid는 실선 dot은 점선을 의미한다. -->
		샘플 박스 입니다.
	</div>
	<div id="sampleBox2" style="border: 1px solid black; width: 300px; height: 300px;"> <!-- solid는 실선 dot은 점선을 의미한다. -->
		샘플 박스 입니다.
	</div>
	<div id="sampleBox3" style="border: 1px solid black; width: 300px; height: 300px;"> <!-- solid는 실선 dot은 점선을 의미한다. -->
		샘플 박스 입니다.
	</div>
	<div id="sampleBox4" style="border: 1px solid black; width: 300px; height: 300px;"> <!-- solid는 실선 dot은 점선을 의미한다. -->
		샘플 박스 입니다.
	</div>
</div>
<script src='${context}/resources/js/attr.js'></script> <!-- 해당 js 파일을 import하겠다는 의미이다. --> <!-- /* type과 src는 직접 코드를 작성하는 것과 import를 하는 차이를 가진다. */ -->
<script type="text/javascript">
$(document).ready(function() { // 자동으로 호출되는 함수 (메인메소드 개념이다.) , 안적어도 되는데 적는게 관례다.
	alert('콜백 함수가 실행되었습니다.')
	$('#callImg').click(function() { // callImg라는 id를 가진 곳에 접근, 클릭 이벤트 설정 (콜백함수를 쓰는 예제다.)
		attr.attrDemo('${context}/resources/img/member/cho.jpg');
	});
	$('#htmlDemo').click(function() { // callImg라는 id를 가진 곳에 접근, 클릭 이벤트 설정 (콜백함수를 쓰는 예제다.)
		//var sampleBox2 = $('#sampleBox2');
		attr.htmlDemo('#sampleBox2');
	});
	$('#textDemo').click(function() {
		attr.textDemo('#sampleBox3')
	})
	$('#sampleBox4').mouseover(function() { // callImg라는 id를 가진 곳에 접근, 클릭 이벤트 설정 (콜백함수를 쓰는 예제다.)
		attr.attrDemo('${context}/resources/img/member/cho.jpg');
	});
});
</script>