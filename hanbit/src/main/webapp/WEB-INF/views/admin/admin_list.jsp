<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 관리자 로그인 시 제일 먼저 호출되는 페이지다. -->

<script src="${context}/resources/js/Global.js"></script>	
<script src="${context}/resources/js/admin.js"></script>	
<script type="text/javascript">
$(function() { 
	var global = new Global('${context}');
	admin.list(global.getContext()); // admin.js에 있는 admin.list() 함수 호출
});
</script>
