<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	.nav li a {color:gray;}
</style>
<header style="width: 100%; margin: 0 auto">
	<h3 style="color: white; text-align: center;">
		<a href="${context}/admin/login_form">관리자 페이지</a>
	</h3>
	<%-- <p style="float: right; margin-right: 50px;">
		<fmt:formatDate type="both" value="${now}" />
	</p> --%>

<nav class = "navbar navbar-inverse">
	<div class = "coniner-fluid">
		<ul class="nav nav-pills" id = "header_ul">
			<!-- 여기엔 관리자가 로그인인지 아닌지 layout_admin.jsp에서 체크해서 폼이 알아서 들어간다. -->
		</ul>
	</div>
</nav>
</header>