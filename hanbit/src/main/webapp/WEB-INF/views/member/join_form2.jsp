<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="mg_auto" style="width: 1000px;">
	<h1>회원 가입 폼</h1>
	<div>
		<form action="${context}/global/main.do" method="get">
			<table>
				<tr>
					<td>
						<h3>아이디</h3>
					</td>
					<td><input type="text" name="id" value=""
						autofocus="autofocus" required="required" /></td>
				</tr>
				<tr>
					<td>
						<h3>비밀번호</h3>
					</td>
					<td><input type="password" required="required" /></td>
				</tr>
				<tr>
					<td>
						<h3>비밀번호 확인</h3>
					</td>
					<td><input type="password" /></td>
				</tr>
				<tr>
					<td>
						<h3>이름</h3>
					</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>
						<h3>주소</h3>
					</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>
						<h3>생일</h3>
					</td>
					<td><input type="text" /></td>
				</tr>
			</table>
			<div>
				<input type="submit" value="가입완료" /> <input type="reset" value="취소" />
				<a href="${context}/global/main.do">홈으로</a>
			</div>
		</form>

	</div>
</div>
<jsp:include page="../global/footer.jsp" />