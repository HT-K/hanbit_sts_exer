<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container" style="width: 1000px; margin: 0 auto;"> <!-- container -> 부트스트랩에서 이미 선언되어있는 클래스  -->
	<div class="row display-table">
		<div class="col-xs-12 col-sm-4 display-cell"> <!-- 아래 리스트목록을 출력하기 위한 블록 크기 설정 클래스 -->
			<ul class="nav nav-pills nav-stacked"> <!-- 리스트 목록에 상자 효과를 주는 CSS 클래스다. -->
				<li class="dropdown active"><a onclick="opr.sysout()">배열출력</a></li> <!-- 각 리스트에 파란색배경이 들어가게 해주는 CSS 클래스다. -->
				<li class="dropdown active"><a onclick="opr.score()">점수출력</a></li>
				<li class="dropdown active"><a onclick="opr.grade()">성적출력</a></li>
				<li class="dropdown active"><a onclick="opr.gender()">성별출력</a></li>
				<li class="dropdown active"><a onclick="opr.bigNum()">가장 큰 수 출력</a></li>
				<li class="dropdown active"><a onclick="opr.gugudan()">구구단 출력</a></li>
				<li class="dropdown active"><a onclick="opr.sum1to100()">1부터 100까지 합 출력</a></li>
				<li class="dropdown active"><a onclick="opr.oddSum()">홀수 합 출력</a></li>
				<li class="dropdown active"><a onclick="liveScript()">라이브 스크립트 호출</a></li>

				<!-- <button onclick="opr.sysout()">배열출력</button> <input type="button" value="배열출력" /> 이것도 왼쪽과 같지만 html5에서는 이 방식을 추천하지 않는다.
				<button onclick="opr.score()">점수출력</button>
				<button onclick="opr.grade()">성적출력</button>
				<button onclick="opr.grade()">성적출력</button>
				<button onclick="opr.grade()">성적출력</button>
				<button onclick="opr.grade()">성적출력</button> -->
			</ul>
		</div>
		<div class="col-xs-12 col-sm-8 display-cell" id="result" style="border: 1px solid black;height: 500px"> <!-- 결과창을 보여주기 위한 블록 크기를 설정하는 CSS 클래스다. -->
        text
    	</div>
	</div>
</div>
<script type="text/javascript">
function liveScript() { /* 객체지향으로 바뀌지 않은 시절에 쓰던 방식, 이 때는 함수호출이라고한다. (객체지향에서는 메소드 호출이라고 부른다.) */
	alert('라이브스크립트 시절(객체기반언어가 아닌 시절)');
}
var opr = { //객체리터럴 방식으로 자바스크립트에서 객체를 생성하는 방식 중 하나다.
	sysout : function() {
		var arr = ['사과', '배', '감', '귤'];
		for ( var i in arr) {
			document.getElementById("result").innerHTML = arr[i] + '<br/>';
			//console.log(arr[i] + '\t');
		}
	},
	score : function() {
		var result = ''; // 초기화 시키기
		var avengers = [];
		avengers.push({name : '아이언', kor : 90, eng : 90, math : 90}); /* .push() 함수는 해당 배열에 값을 추가하고 싶을 때 사용 */
		avengers.push({name : '헐크', kor : 80, eng : 80, math : 80});
		avengers.push({name : '캡아', kor : 70, eng : 70, math : 70});
		
		for ( var i in avengers) {
			avengers[i].getSum = function() {
				return this.kor + this.eng + this.math;
			}
			avengers[i].getAvg = function() {
				return avengers[i].getSum() / 3; // this.getSum() / 3; 도 된다.
			}
			console.log("이름 : " +avengers[i].name + " 합계 =" + avengers[i].getSum() + " 평균 = " + avengers[i].getAvg() + "<br/>");
		}
		result = '========== 어벤져스 성적표 ===========<br/>';
		result += '이름\t국어\t영어\t수학\t총점\t평균<br/>';
		result += '--------------------------------<br/>';
		for ( var i in avengers) {
			{
				with(avengers[i]){
					result += name + ':\t' + kor + ':\t' + eng + ':\t' + math + ':\t' + getSum() + ':\t' + getAvg() + '<br/>';
				}
			}
		}
		document.getElementById("result").innerHTML = result;
		/* 
		with 키워드는 배열에 담긴 하나의 객체를 의미한다. 예를 들어 var iron = {name : '아이언', kor : 90, eng : 90, math : 90}
		이렇게 선언되 하나의 객체를 avengers.push(iron) 이라고 줄 경우
		출력문에서 with를 사용하지 않는다면 iron.name 이런식으로 하나씩 명시해야 하기 떄문에 with를 사용한다.
		*/
	},
	grade : function() {
		/*
			평균
			90이상 A
			80 B
			70 C
			60 D
			미만 F
		*/
		var kor = Number(prompt('국어점수')), // 자바의 parseInt와 같은 것이다. prompt로 받으면 무조건 String으로 받는 것이라 이렇게 해줘야 숫자로 변한다.
			eng = Number(prompt('영어점수')), 
			math = Number(prompt('수학점수'));
		var avg = (kor + eng + math) / 3;
		var res = '';
		if (avg >= 90) {
			res = 'A';
			//console.log("성적 = A");
		} else if (avg >= 80) {
			res = 'B';
			//console.log("성적 = B");
		} else if (avg >= 70) {
			res = 'C';
			//console.log("성적 = C");
		} else if (avg >= 60) {
			res = 'D';
			//console.log("성적 = D");
		} else {
			res = 'F';
			//console.log("성적 = F");
		}
		document.getElementById("result").innerHTML = '학점 = ' + res;
	},
	gender : function() {
		/* 
		800101-1234567 일 경우 flag 값은 1 이다라고 정의함
		*/
		// 성별을 판별하는 로직을 switch - case 로 완성하시오
		var ssn = prompt('주민번호를 입력해주세요 (800101-1234567)');
		var flag = Number(ssn.charAt(7)); 
		// 자바의 switch case 와 동일
		var res = '';
		
		switch (flag) {
		case 1 :
			res = '남자';
			break;
		case 2 :
			res = '여자';
			break;
		case 3 :
			res = '남자';
			break;
		case 4 :
			res = '여자';
			break;
		default:
			alert('유효하지 않은 주민등록번호입니다.');
			return;
		}
		document.getElementById("result").innerHTML = "입력한 주민번호 판별 결과 = " + res + "입니다";
	},
	bigNum : function() {
		/* 80, 70, 60 일 경우 if 문으로 최대값 을 구하는 로직을 완성하시오 */ 	
		var a = Number(prompt('숫자1')), // 자바의 parseInt와 같은 것이다. prompt로 받으면 무조건 String으로 받는 것이라 이렇게 해줘야 숫자로 변한다.
			b = Number(prompt('숫자2')), 
			c = Number(prompt('숫자3'));
		var bigNum = 0;
		
		if (a > b && a > c) {
			bigNum = a;
		} else if (b > a && b > c) {
			bigNum = b;
		} else {
			bigNum = c;
		}
		document.getElementById("result").innerHTML = '가장 큰 수 = ' + bigNum + '입니다.';
		//console.log("가장 큰 수 = " + bigNum);
	},
	gugudan : function() {
		var danNum = Number(prompt('구하실 구구단 수를 입력하세요')); 
		var i=0;
		var res = '';
		
		res += danNum + '단 출력결과 <br/>';
		for (i = 1; i < 10; i++) {
			// 7단 구구단을 출력하시오
			res += danNum + '*' + i + '=' + danNum*i + '<br/>';
			//console.log(j + "*" + i + " = " + i*j + "\n");
		}
		document.getElementById("result").innerHTML = res;
	},
	sum1to100 : function() {
		var sum=0,i=0;
		while (i <= 100) {
			/* 1부터 100까지의 합을 출력하시오*/
			sum += i;
			i++;
		}
		document.getElementById("result").innerHTML = '1부터 100까지의 합 = ' + sum;
		//console.log("1부터 100까지의 합 = " + sum);
	},
	oddSum : function() {
		var oddSum=0,evenSum=0, limit=prompt('홀수 짝수의 합을 구하기 위한 한계 값 입력');
		var i = 0;
		var res = '';
		for (i = 0; i <= limit; i++) {
			// 1부터 100 까지 수 중에서 홀수의 합 oddSum 과 
			// 짝수들의 합 evenSum 을 구하시오
			if (i % 2 == 1) {
				oddSum += i;
			}
			if (i % 2 == 0) {
				evenSum += i;
			}
		}
		res += '1부터 ' + limit + '사이 홀수의 합 = ' + oddSum + '<br/>';
		res += '<hr/>'
		res += '1부터 ' + limit + '사이 짝수의 합 = ' + evenSum + '<br/>';
		document.getElementById("result").innerHTML = res;
	}
}
</script>