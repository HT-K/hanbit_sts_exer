<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!-- tiles 프레임워크를 이용하여 구현한 페이지로 관리자와 관련된 모든 내용은 이 layout_admin.jsp를 거치게 된다. -->
<!-- 이 페이지의 div -> id = content인 곳에 원하는 화면을 .html로 띄워서 마치 한 페이지 안에서 모든 것이 돌아가게끔 보이게 만드는게 주 목적이다. -->
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
<c:when test="${sessionScope.user.cate == 1}"> 
	<script type="text/javascript">
		$(function() {
			var context = $.fn.global('${context}').getContext();
			var article = $.fn.article();
			'<li role="presentation" style="margin-left: 100px">'
			+	'<a href="${context}/article/my_article" id="my_article">내 글들 보기</a>'
			+'</li>'
			+'<li role="presentation" style="margin-left: 100px">'
			+	'<a href="${context}/member/mypage" id="mypage">마이페이지</a>'
			+'</li>'
			+'<li role="presentation" style="margin-left: 100px">'
			+	'<a href="${context}/member/logout" id="logout">로그아웃</a>'
			+'</li>';
			$('#header_ul').html(logout_header);
			
			/* $('#my_article').click(function(e) { // 내 게시글 보기
				e.preventDefault();
				article.myArticle(global.getContext());
			}); */
			$('#mypage').click(function(e) { // 마이페이지
				e.preventDefault();
				member.mypage(context);
			});
			$('#logout').click(function(e) { // 로그아웃
				e.preventDefault(); // 이것을 써주면 a 태그에 href속성에 URL호출내용이 있더라도 실행되지 않고 무시하게 된다.중요중요
				location.href = "${context}/member/logout";
			});
			
			$('#updateBtn').click(function(e) { // profile.jsp의 '수정 폼으로 이동' 클릭 시
				e.preventDefault();
				member.updateForm(context);
			});
			
			$('#deleteBtn').click(function(e) { // profile.jsp의 '회원탈퇴' 클릭 시
				e.preventDefault();
				member.remove(context);
			});
	
		});
	</script>
</c:when>
<c:otherwise>
	<script type="text/javascript">
		$(function() {
			// 팩토리 패턴이다. Hanbit.js에 미리 만들어놓은 생성자들을 이용한 것이다.
			var context = $.fn.global('${context}').getContext();
			var article = $.fn.article();
			var member = $.fn.member();
			/* var global = new Global('${context}'); // 생성자 기법을 통해 Global.js 에 컨텍스트 경로를 저장한다.
			var article = new Article(); // Article 객체 생성 */
			var login_header = 
				'<li role="presentation" style="margin-left: 100px">'
				+	'<a href="#" id="article_all">모든 게시글 보기</a>'
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
				
				$('#article_all').click(function(e) { // 모든 게시글 보기
					alert("넌 올거야");
					e.preventDefault();
					article.articleAll(context, 1);
				});
				$('#join').click(function(e) {
					e.preventDefault();
					member.joinForm(context);
				});
				/* $('#admin_login').click(function(e) {
					e.preventDefault();
					admin.login(global.getContext());
				}); */
		});
	</script>
</c:otherwise>
</c:choose>
</html>
