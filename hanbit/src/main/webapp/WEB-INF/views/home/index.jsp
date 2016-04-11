<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
	<img src="${context}/resources/img/main/hanbit.jpg" alt="" width="100%" height="400px"/>
	<br/>
	<div style="margin-left: 43.5%">
		<div>
			<h4><a href="${context}/member/login">회원 로그인 이동</a></h4>
			<h4><a href="${context}/member/join">회원가입 이동</a></h4>
			<h4><a href="${context}/admin/join">관리자 등록 페이지 이동</a></h4>
			<h4><a href="${context}/admin/login">관리자 로그인 페이지 이동</a></h4>
		</div>
	</div>
<jsp:include page="../global/footer.jsp" />
