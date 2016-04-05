<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container" style="width: 1000px; margin: 0 auto;">
	<h3>jQuery</h3>
	소프트웨어를 제작할 때 자주 사용되는 기능들을 쉽게 사용할 수 있도록 <br />
	모아놓은 자바스크립트 라이브러리
	<h3>사용방법</h3>
	<ul>
		<li><mark>CDN 호스트를 통해 jQuery를 호출</mark></li>
		<li>다운로드한 후 설치하는 방법</li>
		<li></li>
	</ul>
	<h3>특징</h3>
	<ul>
		<li>대소문자 구분</li>
		<li>${document}.ready(function(){}); 을 통해 무조건 실행하는 환경 설정, 자바의 메인메소드와 같다고 보면된다.</li>
	</ul>
	<h3>함수</h3>
	<ul>
		<li>jQuery() 또는 $()를 말한다.</li> <!-- $()는 내부적으로 getter와 같다, 리턴 값으로 객체를 준다 -->
		<li>이 함수는 jQuery 래퍼(wrapper) 라고도 불리우며 <br />
			DOM을 탐색한다. 또한 엘리먼트를 반환하며, 결과값으로 객체를 얻어준다. <br />
			이렇게 얻어진 객체를 jQuery 확장 객체 집합 또는 jQuery 객체라고 한다.
		</li>
	</ul>
	<h3>콜백 함수</h3>
	<ul>
		<li>개발자가 지정해 놓으면 <mark>이벤트</mark>에 따라 자동으로 호출되는 함수</li>
		<li>$는 jQuery의 별칭으로 사용하는 기호이다. <br /> <!-- jQuery $ = new jQuery() 라고 생각하면 쉽다. -->
			$기호를 사용하여 () 안의 매개변수로 셀렉터를 기술하여 jQuery 객체집합을 얻어낼 수 있다.
		</li>
	</ul>
</div>