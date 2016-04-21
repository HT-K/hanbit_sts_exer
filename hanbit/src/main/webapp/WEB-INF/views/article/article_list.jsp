<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
	
	<table class="table table-bordered">
		<c:if test="${command.totalPages > 0 }">
		<tr>
			<td colspan="5">
				${command.startRow+1} - ${command.endRow}
				[${command.startRow+1}/${command.totalArticle}]
			</td>
		</tr>
		</c:if>
		<tr style="background-color: yellow">
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:choose>
		<c:when test="${command.totalArticle == 0}">
		<tr>
			<td colspan="5" style="text-align: center;">
				게시글이 없습니다.
			</td>
		</tr>
		
		</c:when>
		<c:otherwise>
		<c:forEach var="article" items="${article}">
		<tr>
			<td>${article.articleId}</td>
			<td>
				<%-- <c:if test="${article.level}>0">
				<c:forEach begin="1" end="${article.level}">-</c:forEach>&gt;
				</c:if> --%>
				<!-- href="${context}/article/search/${article.articleId}" -->
				<a class="list_title" href="${context}/article/detail/${article.articleId}">${article.title}</a>
			</td>
			<td>${article.writerName}</td>
			<td>${article.postingDate}</td>
			<td>${article.readCount}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" style="text-align: center;">
			<!-- 네비게이션, 페이지 이동하는 <1 2 3 4 5> 를 표현하는 부트스트랩  -->
				<nav> 
				  <ul class="pagination">
				  	<c:if test="${command.startPage - command.pageSize gt 0}"> <!-- 현재페이지가 4페이지고 pageSize(한 화면에 보일 페이지 개수)가 3이면 이전페이지를 알리는 버튼을 보여준다. -->
					    <li>
					    	<!-- 현재 페이지가 4이고 pageSize가 3일 때 <<(이전페이지)버튼을 누르면 자동으로 1페이지에 있는 게시글이 보이도록 설정! -->
					      	<a href="${context}/article/article_home?pageNo=${command.startPage-command.pageSize}&keyField=${command.keyField}&keyword=${command.keyword}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      	</a>
					    </li>
					</c:if>
				    <!-- 일반 for문이라고 생각하면됨 , i 는 begin ~ end까지, step(1)는 증가값!  -->
				    <c:forEach varStatus="i" begin="${command.startPage}" end="${command.endPage}" step="1" >
						<c:choose>
							<c:when test="${i.index == command.pageNo}">
								<!-- 현재 클릭한 페이지를 뜻하는 파란색 백그라운드 효과 -->
		 						<li class="active"><span>${i.index}<span class="sr-only">(current)</span></span></li> 
							</c:when>
							<c:otherwise>
								<!-- 현재 내가 클릭한 페이지를 제외한 나머지는 하얀색 백그라운드 -->
								<li><span><a href="${context}/article/article_home?pageNo=${i.index}&keyField=${command.keyField}&keyword=${command.keyword}">${i.index}</a></span></li> 
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${command.totalPages-command.endPage gt 0}"> <!-- 게시글이 21개 articleSize가 5라면 totalPages는 5이다. 토탈 페이지가 5이고 현재 화면에 끝 페이지가 3이라면 다음 페이지를 알리는 버튼을 보여준다 -->
					    <li>
					    	<!-- startPage 가 1이고 한번에 보여줄 페이지 수(pageSize)가 3일 때 >>(다음페이지)버튼을 누르면 4가 보여져야하므로 startPage+pageSize를 pageNo에 담아서 보낸다. -->
					      	<a href="${context}/article/article_home?pageNo=${command.startPage+command.pageSize}&keyField=${command.keyField}&keyword=${command.keyword}" aria-label="Next"> 
					        <span aria-hidden="true">&raquo;</span>
					      	</a>
					    </li>	
					</c:if>
				  </ul>
				</nav>
			</td>
		</tr>
		</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="5" style="text-align: center;">
			<form style="margin: 0; padding: 0;">
				<select name="keyField" id="keyField">
					<!-- DB에 접근할 떄 value와 db컬럼명이 같아야한다. -->
					<option value="title" selected="selected">제목</option>
					<option value="writer_name">이름</option>
				</select>
				<input type="text" id="keyword" name="keyword" value=""/>
				<input type="submit" id="searchBtn" name="searchBtn" value="검색" />
			</form>
			</td>
		</tr>
	</table>
</div>