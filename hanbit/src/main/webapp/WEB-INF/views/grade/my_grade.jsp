<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="mg_auto" style="width: 1000px;">
	<form action="${context}/grade/my_grade.do">
		<table border="1">
			<tr>
				<td><h3>과목</h3></td>
				<td><h3>점수</h3></td>
			</tr>
			<tr>
				<td><h3>java</h3></td>
				<td><input type="text" value="${score.java}"/></td>
			</tr>
			<tr>
				<td><h3>jsp</h3></td>
				<td><input type="text" value="${score.jsp}"/></td>
			</tr>
			<tr>
				<td><h3>spring</h3></td>
				<td><input type="text" value="${score.spring}"/></td>
			</tr>
			<tr>
				<td><h3>sql</h3></td>
				<td><input type="text" value="${score.sql}"/></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="내 성적확인" />
	</form>
</div>
<jsp:include page="../global/footer.jsp" />