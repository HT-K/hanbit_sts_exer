<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class = "mg_auto" style="width: 1000px;">
	<div>
		<table border="1">
			<tr>
				<td rowspan="4"></td>
				<td>
					<h3>아이디</h3>
				</td>
				<td><input type="text" value="${member.id}" /></td> <!-- 출력할 때 value에 이런식으로 적어야 한다. Controller에서 member의 값을 request객체에 담아서 detail.jsp 페이지로 보낸다. 그것을 이용한다. -->
			</tr>
			<tr>
				<td>
					<h3>이름</h3>
				</td>
				<td><input type="text" value="${member.name}"/></td>
			</tr>
			<tr>
				<td>
					<h3>비밀번호</h3>
				</td>
				<td><input type="password" value="${member.password}"/></td>
			</tr>
			<tr>
				<td>
					<h3>주소</h3>
				</td>
				<td><input type="text" value="${member.addr}"/></td>
			</tr>
			<tr>
				<td><input type="file" /></td>
				<td>
					<h3>생년월일</h3>
				</td>
				<td><input type="text" value="${member.birth}"/></td>
			</tr>
		</table>
		<div>
			<form action="${context}/grade/my_grade.do" > <!-- $는 request 객체를 뜻한다고 보면된다. 이 request가 가진 member 객체에 id 값을 같이 보낸다. -->
				<input type="hidden" name="id" value="${member.id}"/> <!-- my_grade.do 서블릿에 보낼 때 id 값을 함께 보낸다. -->
				<input type="submit" value="내 성적보기" />
			</form>
		</div>
		<form action="${context}/global/main.do" method="get">
			<input type="submit" value="로그아웃"/>
		</form>
	</div>
</div>
<jsp:include page="../global/footer.jsp" />