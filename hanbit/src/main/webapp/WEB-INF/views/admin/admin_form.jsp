<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div class="container" style="width: 1000px; margin: 0 auto;"> <!-- container -> 부트스트랩에서 이미 선언되어있는 클래스  -->
	<div class="row display-table">
		<div class="col-xs-12 col-sm-4 display-cell"> <!-- 아래 리스트목록을 출력하기 위한 블록 크기 설정 클래스 -->
			<ul id="admin_sidebar" class="nav nav-pills nav-stacked"> <!-- 리스트 목록에 상자 효과를 주는 CSS 클래스다. -->
				<li><a href="#" id="member_list">전체학생 목록보기</a></li> <!-- 각 리스트에 파란색배경이 들어가게 해주는 CSS 클래스다. -->
				<li><a href="#" id="grade_list">전체학생 성적보기</a></li> <!-- 각 리스트에 파란색배경이 들어가게 해주는 CSS 클래스다. -->
			</ul>
		</div>
		<div class="col-xs-12 col-sm-8 display-cell" id="result" style="border: 1px solid black;height: 500px"> <!-- 결과창을 보여주기 위한 블록 크기를 설정하는 CSS 클래스다. -->
      		<!-- 이곳에 각각의 결과가 출력되게 된다. -->
    	</div>
	</div>
</div>
<script src="${context}/resources/js/admin.js"></script>
<script type="text/javascript">
$(document).ready(function() { // 메인 메소드 같은 존재라고 생각하면 편하다.
	$('#result').load('${context}/member/member_list.do'); // result 아이디를 가진 곳에 오른쪽 URL의 결과를 로드시킨다.
	$('#admin_sidebar').children().first().addClass('dropdown active'); 
	$('#admin_sidebar').children().click(function() {
		$(this).addClass('dropdown active');
		$(this).siblings().removeClass('dropdown active');
	});
	
	$("#member_list").click(function() {
		$('#result').empty();
		$('#result').load('${context}/member/member_list.do');
	});
	$("#grade_list").click(function() {
		$('#result').empty();
		$('#result').load('${context}/grade/grade_list.do');
	});
	$("#grade_regist").click(function() {
		$('#result').empty();
		$('#result').load('${context}/admin/grade_add.do');
	});
});
</script>