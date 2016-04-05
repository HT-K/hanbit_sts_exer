<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="grade_list" style="width: 100%; margin-top: 30px">
	<tr style="background-color: yellow">
		<th style="text-align: center">ID</th>
		<th>JAVA</th>
		<th>SQL</th>
		<th>JSP</th>
		<th>SPRING</th>
	</tr>
	<c:forEach var="grade" items="${list}"> <!-- 컨트롤러에서 보내온 list를 member에 담는다 -->
		<tr>
			<td>${grade.id}</td>
			<td>${grade.java}</td>
			<td>${grade.sql}</td>
			<td>${grade.jsp}</td>
			<td>${grade.spring}</td>
		</tr>
	</c:forEach>
</table>

<script>
$(function() { // 메인 메소드 역할
	$('#grade_list').css('border','1px solid black').css('width','100%').css('margin-top','100px');
	$('#grade_list th').css('border','1px solid black').css('text-align','center');
	$('#grade_list tr').css('border','1px solid black');
	$('#grade_list tr td').css('border','1px solid black').css('text-align','center');
});
</script>