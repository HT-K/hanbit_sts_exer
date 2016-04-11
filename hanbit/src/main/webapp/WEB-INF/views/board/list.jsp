<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	table{border: 1px solid black; width: 80%; margin-left: 10%}
	table tr{border: 1px solid black}
	table tr th{border: 1px solid black; text-align: center; background: yellow}
	table tr td{border: 1px solid black}
</style>

<jsp:include page="../global/header.jsp"/>
<table style="border: 1px solid black">
	<c:if test="${listModel.totalPageCount > 0}">
		<tr>
			<td colspan="5">
				${listModel.startRow} - ${listModel.endRow}
				[${listModel.requestPage}/${listModel.totalPageCount}]
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
		<c:when test="${listModel.hasArticle == false}">
			<tr>
				<td colspan="5">
					게시글이 없습니다.9
				</td>
			</tr>
		</c:when>
		<c:otherwise>
		<c:forEach var="article" items="${listModel.articleList}">
		<tr>
			<td>${article.id}</td>
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
		
		<!-- 글쓰기 버튼 tr(줄, 행) -->
		<tr>
			<td colspan="5">
				<a href="">
					<img src="${context}/resources/img/board/write.png" 
					style="width: 50px; height: 50px; 
					float: right; margin-right: 50px"  alt="" />
				</a>
			</td>
		</tr>
		
		<!-- 페이징 tr -->
		<tr> 
			<td colspan="5">
				<c:if test="${startPage-PAGESIZE gt 0}">
					<a href="${context}/article/page/${startPage-PAGESIZE}">◀이전</a>
				</c:if>
				<c:forEach begin="${startPage}" end="${lastPage}" step="1" varStatus="1">
					<c:choose>
						<c:when test="${i.index == pageNo}">
							<font color="red">${i.index}</font>
						</c:when>
						<c:otherwise>
							<a href="${context}/article/page/${page}">${i.index}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${startPage-PAGESIZE gt 0}">
					<a href="${context}/article/page/${startPage+PAGESIZE}">다음▶</a>
				</c:if>
			</td>
		</tr>
		</c:otherwise>
	</c:choose>
	
	<!-- 검색 tr -->
	<tr>
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