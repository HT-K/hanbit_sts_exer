<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
	<meta charset="UTF-8" />
	<title>관리자 페이지</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> <!-- 부트스트랩 홈페이지에서 CDN으로 가져온다. -->
</head>
<body>
	<div id="header">
		<!-- tilse.xml에 설정된 헤더페이지가 들어가게 된다. -->
		<tiles:insertAttribute name="header" />
	</div>
	
	<div id="content">
		<!-- 이 부분에는 tilse.xml에서 설정한 URL형태로 호출되는 페이지가 띄워지게 된다! tiles.xml과 연결됨! -->
		<tiles:insertAttribute name="content" />
	</div>
	
	<div id="footer">
		<!-- tilse.xml에 설정된 푸터페이지가 들어가게 된다. -->
		<tiles:insertAttribute name="footer" />
	</div>
</body>
<c:choose> 
<c:when test="${sessionScope.user.cate == 3}"> 
	<script type="text/javascript">
		$(function() {
			var logout_header = 
				'<li role="presentation" style="float: right; margin: 0 100px 0 0">'
				+'<a href="${context}/admin/logout">로그아웃</a>'
				+'</li>';
			$('#header_ul').html(logout_header);
		});
	</script>
</c:when>
<c:otherwise>
	<script type="text/javascript">
		$(function() {
			var login_header = 
				'<li role="presentation" style="float: right; margin: 0 100px 0 0">'
				+	'<a href="${context}/">Home</a>'
				+'</li>'
				+'<li role="presentation" style="float: right; margin: 0 50px 0 0">'
				+'<a href="${context}/admin/regist">관리자 등록</a>'
				+'</li>';
				$('#header_ul').html(login_header);
		});
	</script>
</c:otherwise>
</c:choose>
</html>
