<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container" style="width: 1000px; margin: 0 auto;"> <!-- container -> 부트스트랩에서 이미 선언되어있는 클래스  -->
	<div>
		변수 선언 : <mark> var i; </mark> <br /> <!-- mark 태그는 특정 문자열에 포인트 색을 주기 위한 태그 -->
		자바스크립트 변수는 데이터 타입을 정확하게 명시하지 않는다. <br />
		다만 값 할당 시 자동으로 데이터 타입이 결정된다.
	</div>
	<div style="margin-top: 30px">
		<ul>
			<li>number (숫자형) : var x = 17;</li>
			<li>String (문자형) : var str = 'test' 혹은 "test" 모두 가능</li>
			<li>boolean (논리형) : var bool = true;</li>
			<li>null : 널 값</li>
			<li>undefined : 변수가 선언되었으나 초기화 되지 않음</li> <!-- 자바스크립트에서 디폴트는 지역변수이다 (객체지향이지만 인스턴스 변수같은건 없다!) -->
			<li>Array(배열) : var arr = ['사과','배','귤']</li>
		</ul>
	</div>
	<div style="margin-top: 30px">
		전역 변수 : 함수 밖에서 선언하거나 var 없이 선언, 모든 함수에서 참조 가능 <br /> <!-- 함수안에서 var없이 num=17 이런식으로 쓰면 이 num은 전역변수가 되어버린다. -->
		지역 변수 : 함수 안에서 선언, 해당 함수에서만 참조 가능
	</div>
	<div style="margin-top: 30px">
		<h3>출력함수</h3>
		document.write('안녕하세요 !!'); --> 자바에서 System.out.println() 과 동일
	</div>
</div>
