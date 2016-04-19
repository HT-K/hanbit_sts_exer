<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div id="header">
		  <tiles:insertAttribute name="header" />
	</div>
	
	<div id="content">
		<tiles:insertAttribute name="content" /> <!-- 이 부분에는 URL로 호출되는 페이지가 띄워지게 된다! tiles.xml과 연결됨! -->
	</div>
	
	<div id="footer">
		  <tiles:insertAttribute name="footer" />
	</div>
</body>
</html>
