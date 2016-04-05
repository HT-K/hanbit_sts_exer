<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container" style="width: 1000px; margin: 0 auto;"> <!-- container -> 부트스트랩에서 이미 선언되어있는 클래스  -->
	<div id="outBox">
		<h3>$('#') 의 예제</h3>
		<button onclick="dom.show()">열기</button>
		<div id="inBox" style="background: red; display: none;">
		<button onclick="dom.hide()">닫기</button>
		</div>
	</div>
	<div>
		<div>
			<h3>append() 의 예제</h3>
			<button onclick="dom.createTag1()">객체 만들기1</button>
		</div>
		<div>
			<h3>empty() 의 예제</h3>
			<button onclick="dom.createTag2()">객체 만들기2</button>
		</div>
		<div>
			<h3>html() 의 예제</h3>
			<button onclick="dom.createTag3()">객체 만들기3</button>
		</div>
	</div>
	<div>
		<div>
			<h3>document.getElementsByTagName() 의 예제</h3>
			<button onclick="dom.selectElementsByTagName()">태그이름으로 찾기</button>
			<div> 
				<span class='bbb'>1번</span>
				<span>2번</span>
				<span class='aaa'>3번</span>
				<span>4번</span>
				<span class='bbb'>5번</span>
				<span>6번</span>
			</div>
		</div>
	</div>
	<div>
		<div>
			<h3>document.getElementsByName() 의 예제</h3>
			<button onclick="dom.selectElementsByName()">이름으로 찾기</button>
			<div> 
				<span class='bbb'>1번</span>
				<span>2번</span>
				<span class='aaa'>3번</span>
				<span>4번</span>
				<span class='bbb'>5번</span>
				<span>6번</span>
			</div>
		</div>
	</div>
	<div id="end_div"></div>
</div>
<script type="text/javascript">
	var dom = {
			show : function() { // display 속성에 디폴트는 on 이다
				$('#inBox').css('display',''); //오른쪽과 같은 문법이다 (왼쪽은 jQuery 문법으로 만든 것), document.getElementById('inBox').style.display = ''; // 아무값도 주지 않은 즉 style.display의 디폴트 값은 '보여주기'이다.
			},
			hide : function() { // display 속성에 none을 주면 off 이다.
				document.getElementById('inBox').style.display = 'none'; // none 값을 display에 주면 해당 객체가 보이지 않게 된다.
				// $('#inBox').css('display,'none');
			},
			createTag1 : function() { // <div style="background: red; width: 500px; height: 100px; margin: 0 0 0 200px"></div> 를 뜻한다. <!-- margin 0 0 0 0 은 시계방향으로 생각하면된다 . 12시 3시 6시 9시  -->
				var elem = document.createElement('div'); // div 요소를 만든다
				var attr = document.createAttribute('style'); // style 속성을 만든다.
				attr.nodeValue = 'background: red; width: 500px; height: 100px; margin: 0 0 0 200px';
				elem.setAttributeNode(attr);
				
				$('#end_div').append(elem);
			},
			createTag2 : function() { // 위의 코드를 아래와 같이 만들 수 있다.
				var elem = document.createElement('div'); // div 요소를 만든다
				elem.setAttribute('style','background: blue; width: 500px; height: 100px; margin: 0 0 0 200px'); // 자바에서 request.serAttribute 쓰는 방식과 동일하다.
				
				$('#end_div').empty(); //기존의 것을 지우고 그위에 덮어쓰게 하기 위함
				$('#end_div').append(elem); // 해당 위치 뒤에(아래)매개변수로 온 것을 추가함.
			},
			createTag3 : function() { // 위의 코드를 아래와 같이 만들 수 있다.
				var elem = document.createElement('div'); // div 요소를 만든다
				elem.setAttribute('style','background: yellow; width: 500px; height: 100px; margin: 0 0 0 200px'); // 자바에서 request.serAttribute 쓰는 방식과 동일하다.
				
				$('#end_div').html(elem); //해당 위치에 있는 것을 지우고 매개변수로 온 것을 위치시킴 (empty()와 append()가 합쳐진 것이라 생각하면 쉽다.)

			},
			selectElementsByTagName : function() { // span 태그 이름을 가진 모든 것을 검사해서 색을 바꿔주고
				var elems = $('span');
				for (var i = 0, elem; elem = elems[i]; i++) {
					elems.css('backgroundColor', 'red');
					//elem.style.backgroundColor = 'red';
				}
			},
			selectElementsByName : function() { // 태그 클래스 중 bbb 로 된 것을 찾아서 색을 바꿔준다.
				var elems = $('.bbb');
				for (var i = 0, elem; elem = elems[i]; i++) {
					elems.css('backgroundColor', 'pink');
					//elem.style.backgroundColor = 'red';
				}
			}
			/* 태그 그 자체에 접근할 떄는 'span' 이런식으로
				태그 아이디에 접근할 때는 '#id' 이런식으로 #을 붙여서
				태그의 클래스에 접근할 때는 '.class' 이런식으로 .을 붙여서 한다.
			*/
	}
</script>