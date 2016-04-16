<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container">
		<a href="${context}/article/article_home"><img src="${img}/board/backBtn.png" id="backBtn" name="backBtn" style="cursor:pointer; width: 80px;height: 30px;float: right;float: right; margin-right: 50px"/></a>
		<img src="${img}/board/writeBtn.png" id="writeBtn" name="writeBtn" style="cursor:pointer; width: 50px;height: 30px;float: right;float: right; margin-right: 50px"/>
</div>

<div id="wrapper">
	<jsp:include page="article_list.jsp" />
</div>

<script src="${js}/article.js"></script>
<script>
$(function() {
	$('#writeBtn').click(function() {
		$('#wrapper').load('${context}/article/writeForm');
	});
	
	
});

</script>