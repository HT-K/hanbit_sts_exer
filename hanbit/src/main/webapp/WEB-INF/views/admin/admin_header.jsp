<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
   .nav li a{margin-left: 20px}
</style>

<header style="width: 100%; margin: 0 auto">
	<nav class="navbar navbar-default">
		<div class="container-fluid"> 
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<a class="navbar-brand" href="#" style="margin-left: 100px">성적관리</a>
					<div id="header_ul">
						<!-- 여기엔 관리자가 로그인인지 아닌지 layout_admin.jsp에서 체크해서 폼이 알아서 들어간다. -->
	        		</div>
	        </div>
		</div>
	</nav>
<h3 style="color: white; text-align: center;">
      <br />
      <br />
      <br />
      <a href="${context }/admin/login_form">관리자 페이지</a>
</h3>
</header>