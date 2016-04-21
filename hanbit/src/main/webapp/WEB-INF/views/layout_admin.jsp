<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
	<meta charset="UTF-8" />
	<!-- 소연이꺼 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>관리자 페이지</title>
	<!-- 소연이꺼 -->
    <link rel="stylesheet" href="${css}/bootstrap.css" media="screen">
    <link rel="stylesheet" href="${css}/custom.min.css">
    
    <!-- 기본적인거 -->
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
	
	<div id="footer" style="text-align: center;">
		<!-- tilse.xml에 설정된 푸터페이지가 들어가게 된다. -->
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
<script src="${js}/subject.js"></script>
<script src="${js}/admin.js"></script>
<script src="${js}/member.js"></script>
<script src="${js}/record.js"></script>
<script src="${js}/Global.js"></script>

<c:choose> 
<c:when test="${sessionScope.user.cate == 3}"> 
	<script type="text/javascript">
		$(function() {
			/* global.setContext('${context}');
			var context = global.getContext();  */
			var global = new Global('${context}'); // 생성자 기법을 통해 Global.js 에 컨텍스트 경로를 저장한다.
			var logout_header = // 관리자가 로그인 했다면 로그아웃 네비를 띄워주자!
				'<ul class="nav navbar-nav">'
				+'<li>'
				+'<a href="#" id="subjectMgmt">과목관리</a>'
				+'</li>'
				+'<li>'
				+'<a href="${context}/record/record_list" id="recordMgmt">성적관리</a>'
				+'</li>'
				+'<li>'
				+'<a href="#" id="memberMgmt">학생관리</a>'
				+'</li>'
				+'<li>'
				+'<a href="#" id="adminMgmt">교직원관리</a>'
				+'</li>'
				+'</ul>'
				+'<ul class="nav navbar-nav navbar-right" style="margin-right: 200px">'
            	+'<li><a href="${context}/admin/logout">로그아웃</a></li>'
         		+'</ul>';
			$('#header_ul').html(logout_header);
			
			$('#subjectMgmt').click(function(e) {
				e.preventDefault();
				//subject.setContext('${context}'); // 컨텍스트 경로를 subject.js로 보내준다.
				subject.list(global.getContext());
			});
			$('#adminMgmt').click(function(e) {
				e.preventDefault();
				alert("교직원관리 클릭 체크");
				//admin.setContext('${context}'); // 컨텍스트 경로를 admin.js로 보내준다.
				admin.list(global.getContext());				
			});
			$('#memberMgmt').click(function(e) {
				e.preventDefault();
				alert("학생관리 클릭 체크");
				//member.setContext('${context}'); // 컨텍스트 경로를 member.js로 보내준다.
				member.list(global.getContext());
				
			}); //('#memberMgmt').click End
			/* $('#recordMgmt').click(function(ㄷ) {
				e.preventDefault();
				record.setContext('${context}'); // 컨텍스트 경로를 record.js로 보내준다.
				record.list();
			}); */
		});
	</script>
</c:when>
<c:otherwise> 
	<script type="text/javascript">
		$(function() {
			var login_header = // 관리자가 로그인 한 상황이 아닐시
				'<ul class="nav navbar-nav">'
				+'<li role="presentation" style="float: right; margin: 0 100px 0 0">'
				+	'<a href="${context}/">Home</a>'
				+'</li>'
				+'</ul>'
				$('#header_ul').html(login_header);
		});
	</script>
</c:otherwise>
</c:choose>
</html>
