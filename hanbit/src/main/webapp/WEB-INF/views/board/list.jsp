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
	$('#writeBtn').click(function() {
		article.writeForm(context);
	});
	
	$('#searchBtn').click(function() {
		var keyField = $('select[name=keyField] option:selected').val(); // select 태그에서 선택된 값을 변수에 담는다.
		var keyword = $('#keyword').val(); // 키워드 텍스트필드에 입력한 값을 받아온다.
		$('#wrapper').empty();
		$('form').attr('action','${context}/article/list').attr('method','post');
		//$('#container').load(context+'article/list?pageNo=1&keyField=${keyField}&keyword=${keyword}'); 
	});
});

</script>