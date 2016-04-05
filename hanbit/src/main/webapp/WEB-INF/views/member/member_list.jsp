<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="member_list" style="width: 100%; margin-top: 30px">
	<tr style="background-color: yellow">
		<th style="text-align: center">아이디</th>
		<th>이름</th>
		<!-- <th>전공</th>
		<th>수강과목</th> -->
		<th>주소</th>
		<th>생년월일</th>
	</tr>
	<c:forEach var="member" items="${list}"> <!-- 컨트롤러에서 보내온 list를 member에 담는다 -->
		<tr>
			<td>${member.id}</td>
			<td><a href="${context}/grade/grade_add.do?id=${member.id}&name=${member.name}">${member.name}</a></td>
			<%-- <td>${member.major}</td>
			<td>${member.subjects}</td> --%>
			<td>${member.addr}</td>
			<td>${member.birth}</td>
		</tr>
	</c:forEach>
</table>

<script type="text/javascript">
$(function() { // 메인 메소드 역할
	$('#member_list').css('border','1px solid black').css('width','100%').css('margin-top','100px');
	$('#member_list th').css('border','1px solid black').css('text-align','center');
	$('#member_list tr').css('border','1px solid black');
	$('#member_list tr td').css('border','1px solid black').css('text-align','center');
});
</script>