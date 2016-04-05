<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
<form id="grade_add_form">
<table>
	<tr>
		<td>아이디</td>
		<td><input type="text" name ="id" size="30" autofocus /></td>
	</tr>
	<tr>
		<td>java</td>
		<td><input type="text" name="java" size="30" maxlength ="15" /></td>
	</tr>
	<tr>
		<td>jsp</td>
		<td><input type="text" name="jsp" size="30" maxlength ="15" /></td>
	</tr>
	<tr>
		<td>sql</td>
		<td><input type="text" name = "sql" size="30" /></td>
	</tr>
	<tr>
		<td>spring</td>
		<td><input type="text" name = "spring" size="30" /></td>
	</tr>
</table>
	<div>
	<button id="add"></button>
	<input type="submit" value="추가" />
	<input type="submit" value="취소" formaction="${context}/member/admin_form.do"/>
	</div>
</form>
</div>

<script>
	$(function() {
		$('#grade_add_form').attr('action','')
	});
</script>