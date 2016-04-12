<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	table{border: 1px solid black; width: 80%; margin-left: 10%}
	table tr{border: 1px solid black}
	table tr th{border: 1px solid black; text-align: center; background: yellow}
	table tr td{border: 1px solid black}
</style>
<jsp:include page="../global/header.jsp"/>
<div id="wrapper"> <!-- 아래 모든 내용을 감싼다. -->
	<div> <!-- 글쓰기 버튼 -->
		<img src="${context}/resources/img/board/write.png" id="writeBtn" style="width: 50px; height: 50px; float: right; margin-right: 50px; cursor: pointer"  alt="" />
	</div>
	
	<table style="border: 1px solid black">
		<c:if test="${command.totalPages > 0}">
			<tr>
				<td colspan="5">
					${command.startRow+1}-${command.endRow}
					[${command.pageNo}/${command.totalPages}]
				</td>
			</tr>
		</c:if>
		
		<!-- 테이블 각 열들 제목 -->
		<tr>
			<!-- meta 정보는 th로 하라는게 일반적이다.  -->
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		
		<c:choose>
			<c:when test="${command.count == 0}">
				<tr>
					<td colspan="5">
						게시글이 없습니다.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
			<!-- 디비에서 가져온 글들 보여주는 th! -->
			<c:forEach var="article" items="${article}">
			<tr>
				<td>${article.sequenceNo}</td>
				<td>
					<c:if test="${article.level > 0}">
						<c:forEach begin="1" end="${article.level}">-</c:forEach>&gt;
					</c:if>
					<!-- 글 제목을 눌렀을 시 해당 글이 있는 페이지를 같이 보낸다. -->
					<a href="${context}/article/page/${page}">
						${article.title}
					</a>
				</td>
				<td>${article.writerName}</td>
				<td>${article.postingDate}</td>
				<td>${article.readCount}</td>
			</tr>
			</c:forEach>
			
			<!-- 페이징 tr -->
			<tr> 
				<td colspan="5">
					<c:if test="${command.startPage - command.pageSize gt 0}">
						<a href="${context}/article/page/${command.startPage-command.pageSize}">◀이전</a>
					</c:if>
					<c:forEach begin="${command.startPage}" end="${command.endPage}" step="1" varStatus="1">
						<c:choose>
							<c:when test="${i.index == command.pageNo}">
								<font color="red">${i.index}</font>
							</c:when>
							<c:otherwise>
								<a href="${context}/article/page/${page}">${i.index}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${command.startPage - command.pageSize gt 0}">
						<a href="${context}/article/page/${command.startPage+command.pageSize}">다음▶</a>
					</c:if>
				</td>
			</tr>
			</c:otherwise>
		</c:choose>
		
		<!-- 검색 tr -->
		<tr style="text-align: center;">
			<td colspan="5">
				<form action="${context}/article/option">
					<select name="keyField" id="keyField">
						<option value="id" selected="selected">아이디</option>
						<option value="name">이름</option>
					</select>
					<input type="text" name="keyword" value="" />
					<input type="hidden" name="pageNo" />
					<input type="hidden" name="command" value="main" />
					<input type="submit" value="검색" />
				</form>
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
	$(function() {
		$('#writeBtn').click(function() {
			$('#wrapper').empty(); // wrapper div만 남겨놓고 그안에 있는 모든 내용을 비운다(empty)
			var writeForm = '<form action="${context}/article/write" method="post">'
							+ '제목: <input type="text" name="title" size="20" /> <br />'
							+ '작성자: <input type="text" name="writerName" /> <br />'
							+ '글암호: <input type="password" name="password" /> <br />'
							+ '글내용: <br />'
							+ '<textarea name="content" id="content" cols="40" rows="5"></textarea>'
							+ '<br />'
							+ '<input type="submit" value="작성완료"/>'
							+ '</form>';
			$('#wrapper').html(writeForm);
		});
	});
</script>