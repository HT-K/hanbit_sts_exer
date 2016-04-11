<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<h3>${member.name} 성적 수정</h3>
<form id="grade_input_form">
<table id="grade_list" style="width: 100%; margin-top: 30px">
	<tr style="background-color: yellow">
		<th style="text-align: center">시험날짜</th>
		<th>무슨시험?</th>
		<th>아이디</th>
		<th>이름</th>
		<th>시험과목번호</th>
		<th>점수</th>
	</tr>
		<tr>
			
			<td><input type="text" id="id" name="id" value="${member.id}" readonly="readonly"/></td>
			<td><input type="text" id="name" name="name" value="${member.name}" readonly="readonly"/></td>
			<td><input type="text" id="subj_seq" name="subj_seq"/></td>
			<td><input type="text" id="score" name="score"/></td>
		</tr>
	<tr>
		<td colspan="6">
			<button id="grade_input">수 정</button>
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
		$('#grade_input_form').attr('action','${context}/grade/update').attr('method','post');
	});
	$('#grade_cancel').click(function() {
		$('#grade_input_form').reset();
	});
});
</script>