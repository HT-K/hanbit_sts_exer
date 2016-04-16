<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container">
		<a href="${context}/article/article_home"><img src="${img}/board/backBtn.png" id="backBtn" name="backBtn" style="cursor:pointer; width: 80px;height: 30px;float: right;float: right; margin-right: 50px"/></a>
		<img src="${img}/board/writeBtn.png" id="writeBtn" name="writeBtn" style="cursor:pointer; width: 50px;height: 30px;float: right;float: right; margin-right: 50px"/>
</div>

<div id="wrapper">
	<jsp:include page="article_list.jsp" /> 
</div>

<script src="${js}/article.js"></script> <!-- var article = {}, article 객체가 들어있다. -->
<script>
$(function() {
	var context = "${context}";
	article.setContext(context); // article 객체의 함수 setContext()에 context 값을 파라미터로 보낸다!
	
	$('#writeBtn').click(function() { // '글쓰기' 버튼 클릭 시 호출되는 함수
		article.writeForm();
	});
	
	$('.list_title').click(function() { // 게시글의 제목을 클릭했을 때 호출되는 메소드, 해당 제목에 해당하는 글을 띄워주기 위함
		// a태그를 클릭했을 때 (반드시 클래스로 설정해야한다, id로 click를 설정하면 안먹힌다!)
		// 해당 태그(this)의 href 속성의 값을 가져온다. (getter 개념)
		// 가져온 URL을 article.detail 함수에 매개변수로 보낸다
		article.detail($(this).attr('href')); // 왼쪽과 같은 문법이다. article.detail(this.getAttribute('href'));
		return false; // a태그의 기본 행동이 곧바로 href로 넘어가는건데 여기서 ajax를 호출 할 거라서 잠시 그 행동을 멈추게 한다~
	});
});
</script>