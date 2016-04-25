<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!-- tiles 프레임워크를 이용하여 구현한 페이지로 관리자와 관련된 모든 내용은 이 layout_admin.jsp를 거치게 된다. -->
<!-- 이 페이지의 div -> id = content인 곳에 원하는 화면을 .html로 띄워서 마치 한 페이지 안에서 모든 것이 돌아가게끔 보이게 만드는게 주 목적이다. -->
<html>
<head>
	<meta charset="UTF-8" />
	<!-- 소연이꺼 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>관리자 페이지</title>
    
    <!-- 기본적인거 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> <!-- 부트스트랩 홈페이지에서 CDN으로 가져온다. -->
</head>
<body>
	<div id="header">
		<!-- tiles.xml에 설정된 헤더페이지가 들어가게 된다. -->
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

<!-- div -> id = content인 곳에 보이게 될 페이지와 그 기능들을 담고 있는 .js파일들이다. -->
<!-- 이 파일에 객체리터럴 혹은 함수표현식으로 작성된 것들을 호출해서 content에 .html로 내용을 브라우저 화면에 띄우게 된다.  -->
<script src="${js}/Admin.js"></script> <!-- 관리자와 관련된 페이지와 기능을 모아놓은 js파일 -->
<script src="${js}/Article.js"></script> <!-- 게시판과 관련된 페이지와 기능을 모아놓은 js파일 -->
<script src="${js}/Global.js"></script> <!-- web/까지 경로를 의미하는 ${context}를 어느 js파일에서든 쓸 수 있도록 get,set이 들어있는 js파일 -->
<script src="${js}/Grade.js"></script> <!-- 성적과 관련된 페이지와 기능을 모아놓은 js파일 -->
<script src="${js}/Hanbit.js"></script> <!-- 팩토리 패턴의 공장과 같은 역할을 하는 js파일이다. 만약 각 js 파일안에 함수표현식으로 시작되는 것이 있다면 이안에서 new를 이용하여 해당 함수표현식을 객체로 만들 수 있다. -->
<script src="${js}/Member.js"></script> <!-- 회원과 관련된 페이지와 기능을 모아놓은 js파일 -->
<script src="${js}/Record.js"></script> <!-- 뷰로 만들어진 성적 -->
<script src="${js}/Subject.js"></script> <!-- 과목과 관련된 페이지 -->

<c:choose> 
<c:when test="${sessionScope.user.cate == 3}"> 
	<script type="text/javascript">
		$(function() {
			var context = $.fn.global('${context}').getContext();
			var article = $.fn.article();
			//var global = new Global('${context}'); // 생성자 기법을 통해 Global.js 에 컨텍스트 경로를 저장한다.
			var logout_header = // 관리자가 로그인 했다면 로그아웃 네비를 띄워주자!
				'<ul class="nav navbar-nav">'
				+'<li>'
				+'<a href="#" id="adminMgmt">교직원관리</a>'
				+'</li>'
				+'<li>'
				+'<a href="#" id="memberMgmt">학생관리</a>'
				+'</li>'
				+'<li>'
				+'<a href="${context}/record/record_list" id="recordMgmt">성적관리</a>'
				+'</li>'
				+'<li>'
				+'<a href="#" id="subjectMgmt">과목관리</a>'
				+'</li>'
				+'</ul>'
				+'<ul class="nav navbar-nav navbar-right" style="margin-right: 200px">'
            	+'<li><a href="#" id="logout">로그아웃</a></li>'
         		+'</ul>';
			$('#admin_header').html(logout_header);
			
			$('#adminMgmt').click(function(e) { // 교직원 관리
				e.preventDefault();
				alert("교직원관리 클릭 체크");
				admin.list(global.getContext());				
			});
			$('#memberMgmt').click(function(e) { // 학생 관리
				e.preventDefault();
				alert("학생관리 클릭 체크");
				member.list(global.getContext());
			});
			/* $('#recordMgmt').click(function(e) { // 성적관리
				e.preventDefault();
				record.list(global.getContext());
			}); */
			$('#subjectMgmt').click(function(e) { // 과목관리
				e.preventDefault();
				subject.list(global.getContext());
			});
 			$('#logout').click(function(e) { // 로그아웃
				e.preventDefault();
				location.href = "${context}/admin/logout";
			});
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
				$('#admin_header').html(login_header);
		});
	</script>
</c:otherwise>
</c:choose>
</html>
