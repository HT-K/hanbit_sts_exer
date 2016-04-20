<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id=wrapper>
</div>
<script src="${context}/resources/js/admin.js"></script>	
<script src="${context}/resources/js/subject.js"></script>	
<script type="text/javascript">
$(function() { // 잊지말자 자바의 메인메소드 같은 것
	subject.setContext('${context}');
	subject.list(); // wrapper div를 .html로 지우고 거기에 subject_list를 띄운다.
});
</script>