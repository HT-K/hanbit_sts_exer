<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="admin_header.jsp"/>
<div id="parent">부모
	<div id="son1">아들1</div>
	<div id="son2">아들2</div>
	<div id="son3">아들3</div>
	<div id="son4">아들4</div>
</div>
<script type="text/javascript">
	$(function() {
		$('#parent').css('background-color', 'yellow').css('width','500px').css('height','500px');
		$('#son1').css('background-color', 'white').css('width','100px').css('height','100px');
		$('#son2').css('background-color', 'white').css('width','100px').css('height','100px');
		$('#son3').css('background-color', 'white').css('width','100px').css('height','100px');
		$('#son4').css('background-color', 'white').css('width','100px').css('height','100px');

		
		$('#parent').click(function() { // 자신이 포함하고 있는 자식들의 배경을 파란색으로
			$(this).children().css('background-color', 'blue')
		});
		$('#son1').click(function() {
			$(this).css('background-color', 'red'); // 자기 자신만 바꿈
		});
		$('#son2').click(function() {
			$(this).parent().css('background-color', 'green'); // 자신을 감싸는 부모를 바꿈
		});
		$('#son3').click(function() {
			$(this).siblings().css('background-color', 'pink'); // 자신과 같은 라인에 있는 형제들을 바꿈
		});
	});
</script>

