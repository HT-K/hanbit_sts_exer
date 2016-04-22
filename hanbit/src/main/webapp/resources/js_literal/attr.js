/**
 *	jQuery 속성 예제
 */

var attr = { // .js파일에 코드를 작성하는 것은 Bean 클래스를 만드는 것으로 생각하면 쉽다.
	attrDemo : function(imgPath) { // <img/>는 표기법이다. 이 함수를 호출하면 자동으로 img 태그가 생성되면서 오른쪽에 생성된 객체가 속성으로 들어가게 된다.
		$('<img/>',{src:imgPath,width:'100%',height:'100%'}).appendTo($('#sampleBox4').empty()); // 노드는 자바의 객체와 같은 뜻이다.
		// sampleBox4 아이디를 가진 곳의 내용을 empty() 모두 비우고 img 태그를 생성하여 그 안에 속성 (src~~~)을 넣는다는 뜻이다.
	},
	htmlDemo : function(target) { // 1. sampleBox 아이디를 가진 곳의 내용을 비우고, div(sysout.println)생성
		$('<div id="htmlBox"><div/>').appendTo($(target).empty()); // 싱글 쿼터를 연속으로 사용하면 중간에 복잡해주는데 자바스크립트에서는 '', "" 둘 다 허용해서 편리한 것이다!
		// 위에서 생성된 div의 id 값인 htmlBox를 이용하여 $로 접근, .html()을 이용해서 그곳의 내용을 변경한다.
		$('#htmlBox').html('<div style = "background : yellow; width:300px; height:300px;">노란 박스가 생성됨.</div>');
	},
	textDemo : function(target) {
		$('<div id="textBox"><div/>').appendTo($(target).empty()); 
		$('#textBox').text('노란박스');
	}
}