<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id=wrapper>
</div>
<script type="text/javascript">
$(function() { // 메인 메소드 역할
	member.setContext('${context}');
	member.list(); // wrapper div를 .html로 지우고 거기에 subject_list를 띄운다.
});
</script>