<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="admin_header.jsp"/>
<form action="">
<fieldset>
<legend>회원관리</legend>
<table class="table-condensed" style="width: 90%; margin-left: 50px">
	<tr>
		<td>전체회원 목록보기</td>
		<td>
			<jsp:include page="../member/member_list.jsp"/>
		</td>
	</tr>
	<tr>
		<td>ID로 회원 검색</td>
		<td id="allList" style="display: none">
			<input type="text" id="searchById" name="searchById" />
		</td>
	</tr>
	<tr>
		<td>이름으로 회원검색(동명이인 허용)</td>
		<td id="allList" style="display: none">
			<input type="text" id="searchByName" name="searchByName" />
		</td>
	</tr>
	<tr>
		<td>학생 점수 입력</td>
		<td id="allList" style="display: none">
			<jsp:include page="../member/member_list.jsp"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button>전송</button>
			<button>취소</button>
		</td>
	</tr>
</table>
</fieldset>
</form>