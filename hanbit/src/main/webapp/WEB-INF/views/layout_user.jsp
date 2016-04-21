<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
	<meta charset="UTF-8" />
	<title>회원페이지</title>
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
<script src="${js}/subject.js"></script>
<script src="${js}/admin.js"></script>
<script src="${js}/member.js"></script>
<script src="${js}/record.js"></script>
<script src="${js}/Global.js"></script>

<c:choose> 
<c:when test="${sessionScope.user.cate == 1}"> 
	<script type="text/javascript">
		$(function() {
			var global = new Global('${context}'); // 생성자 기법을 통해 Global.js 에 컨텍스트 경로를 저장한다.
			var logout_header = 
				'<li role="presentation" style="margin-left: 100px">'
			+		'<a id="article_list" href="${context}/article/article_home">게시판</a>'
			+	'</li>'
			+	'<li role="presentation" style="margin-left: 100px">'
			+		'<a href="${context}/member/logout">로그아웃</a>'
			+	'</li>'
			+	'<li role="presentation" style="margin-left: 100px">'
			+		'<a id="mypage" href="${context}/member/mypage">마이페이지</a>'
			+	'</li>';
			$('#header_ul').html(logout_header);
			
			/* $('#article_list').click(function(e) {
				e.preventDefault();
				article.list(global.getContext());
			}); */
			/* $('#mypage').click(function(e) {
				e.preventDefault();
				member.mypage(global.getContext());
			}); */
			
			$('#updateBtn').addClass('btn btn-primary').click(function() { // 수정 폼 이동 클릭 시 URL에 id 값을 가지고 넘어간다.
				member.updateForm(global.getContext());
			});
/* 			$('#delBtn').addClass('btn btn-primary').click(function() {
			}); */
		});
	</script>
</c:when>
<c:otherwise>
	<script type="text/javascript">
		$(function() {
			var global = new Global('${context}'); // 생성자 기법을 통해 Global.js 에 컨텍스트 경로를 저장한다.
			var login_header = 
				'<li role="presentation" style="margin-left: 100px">'
				+	'<a id="article_list" href="${context}/article/article_home">게시판 바로 가기</a>'
				+'</li>'
				+'<li role="presentation" style="margin-left: 100px">'
				+	'<a href="${context}/member/login_form">로그인</a>'
				+'</li>'
				+'<li role="presentation" style="margin-left: 100px">'
				+	'<a id="join" href="${context}/member/join_form">회원가입</a>'
				+'</li>'
				+'<li role="presentation" style="margin-left: 100px">'
				+	'<a id="admin_login" href="${context}/admin/login_form">관리자</a>'
				+'</li>';
				$('#header_ul').html(login_header);
				
				/* $('#article_list').click(function(e) {
					e.preventDefault();
					article.list(global.getContext());
				});
				$('#join').click(function(e) {
					e.preventDefault();
					member.join(global.getContext());
				});
				$('#admin_login').click(function(e) {
					e.preventDefault();
					admin.login(global.getContext());
				}); */
		});
	</script>
</c:otherwise>
</c:choose>
</html>
