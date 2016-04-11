<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="grade_list" style="width: 100%; margin-top: 30px">
	<tr style="background-color: yellow">
		<th style="text-align: center">점수번호</th>
		<th>아이디</th>
		<th>과목번호</th>
		<th>점수</th>
	</tr>
	<c:forEach var="grade" items="${grade}"> <!-- 컨트롤러에서 보내온 grade(list)를 grade에 담는다 -->
		<tr>
			<td>${grade.score_seq}</td>
			<td><a href="${context}/grade/update/${grade.id}">${grade.id}</a></td>
			<td>${grade.subj_seq}</td>
			<td>${grade.score}</td>
		</tr>
	</c:forEach>
</table>

<script type="text/javascript">
$(function() { // 메인 메소드 역할
	$('#grade_list').css('border','1px solid black').css('width','100%').css('margin-top','100px');
	$('#grade_list th').css('border','1px solid black').css('text-align','center');
	$('#grade_list tr').css('border','1px solid black');
	$('#grade_list tr td').css('border','1px solid black').css('text-align','center');
});
</script>