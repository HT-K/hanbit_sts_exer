<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<h3>${member.name} 성적 입력</h3>
<form id="grade_input_form">
<table id="grade_list" style="width: 100%; margin-top: 30px">
	<tr style="background-color: yellow">
		<th style="text-align: center">Java</th>
		<th>JSP</th>
		<th>SQL</th>
		<th>Spring</th>
	</tr>
		<tr>
			<td><input type="number" id="java" name="java"/></td>
			<td><input type="number" id="jsp" name="jsp"/></td>
			<td><input type="number" id="sql" name="sql"/></td>
			<td><input type="number" id="spring" name="spring"/></td>
			<td><input type="hidden" id="id" name="id" value="${member.id}"/></td>
		</tr>
	<tr>
		<td colspan="4">
			<button id="grade_input">입 력</button>
			<button id="grade_cancel">취 소</button>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
$(function() { // 메인 메소드 역할
	$('#grade_list').css('border','1px solid black');
	$('#grade_list th').css('border','1px solid black').css('text-align','center');
	$('#grade_list tr').css('border','1px solid black');
	$('#grade_list tr td').css('border','1px solid black').css('text-align','center');
	
	$('#grade_input').click(function() {
		$('#grade_input_form').attr('action','${context}/grade/grade_insert.do').attr('method','post');
	});
	$('#grade_cancel').click(function() {
		
		
		$('#grade_input_form').reset();
	});
});
</script>