<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header style="width: 100%; margin: 0 auto"> <!-- 헤더 부분 설정, 보통 사이트 이미지로고와 login, mypage 등과 같은 것들이 작은 메뉴로 들어간다. -->
		<h3 style="color: white; text-align: center;">
			<a href="${context}/admin/login">관리자 페이지</a>
		</h3>
		<p style="float:right; margin-right: 50px;"><fmt:formatDate type="both" value="${now}"/>
		<%-- <span style="float:right; margin-right: 50px;"><%= year %>년<%= month %>월 <%= date%>일 <%= now %></span> --%>
		<ul class="nav nav-pills">
			<li role="presentation" style="float: right; margin: 0 100px 0 0">
				<a href="${context}/">로그아웃</a>
			</li>
			<li role="presentation" style="float: right; margin: 0 100px 0 0">
				<a href="${context}/">Home</a>
			</li>
			
		</ul>
	</header>