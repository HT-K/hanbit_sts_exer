<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="wrapper">
	<jsp:include page="list_table.jsp" />
</div>
<script src="${js}/article.js"></script>
<script>
$(function() {
	// .js 확장자는 ${context} 경로를 알지못한다, common.jspf는 .jsp 확장자를 가진 파일에서만 쓸 수 있다.
	// 그래서 이 list.jsp에서 매개변수로 해당 URL을 보내줘야한다! (딱 article까지만 보내면 그 뒤엥 .js 파일안에서 필요한 메소드명을 적어주면 이 url변수하나로 모든 것을 처리할 수 있다.)
	var context = "${context}"
	article.setContext(context);
	$('#writeBtn').click(function() {
		article.writeForm();
	});
	
	$('#searchBtn').click(function() {
		var keyField = $('select[name=keyField] option:selected').val(); // select 태그에서 선택된 값을 변수에 담는다.
		var keyword = $('#keyword').val(); // 키워드 텍스트필드에 입력한 값을 받아온다.
		//$('#wrapper').empty();
		$('form').attr('action','${context}/article/list').attr('method','post');
		//$('#container').load(context+'article/list?pageNo=1&keyField=${keyField}&keyword=${keyword}'); 
	});
	
	$('.searchById').click(function() {
		// a태그를 클릭했을 때
		// 해당 태그(this)의 href 속성의 값을 가져온다. (getter 개념)
		// 가져온 URL을 article.detail 함수에 매개변수로 보낸다
		article.detail($(this).attr('href')); // 왼쪽과 같은 문법이다. article.detail(this.getAttribute('href'));
		return false; // a태그의 디폴트 동작이 해당 URL을 통해 그 다음 페이지로 가는 것인데 우리는 이 동작이 바로 실행되면 안돼므로 디폴트 동작을 막는 return false를 써줘야한다!
	});
});

</script>