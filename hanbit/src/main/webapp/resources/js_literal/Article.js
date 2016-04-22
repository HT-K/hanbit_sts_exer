/**
 * 게시판 
 */
function Article(){
	this.replyForm = '<form>'
		+'<div class="form-group">'
		+'<label for="exampleInputFile">댓 글</label>'
		+'<form><textarea name="reply" id="reply" class="form-control"  rows="10"></textarea></form>'
		+'<button type="submit" id="updateForm" class="btn col-xs-6 btn-success btn-lg" >확 인</button>'
		+'<button type="submit" id="replySubmit" class="btn col-xs-6 btn-warning btn-lg" >취 소</button>'
		+'</form>';
	this.writeForm = '<form>'
		+'<div class="form-group">'
		+'<label for="exampleInputEmail1">제목</label>'
		+'<input type="text" class="form-control" id="title" name="title" placeholder="제 목">'
		+'</div>'
		+'<div class="form-group">'
		+'<label for="exampleInputPassword1">작성자</label>'
		+'<input type="text" class="form-control" id="writerName" name="writerName" placeholder="작 성 자"></div>'
		+'<div class="form-group">'
		+'<label for="exampleInputFile">비밀번호</label>'
		+'<input type="password" id="password" class="form-control" name="password" placeholder="비 밀 번 호"></div>'
		+'<div class="form-group">'
		+'<label for="exampleInputFile">글내용</label>'
		+'<textarea id="content" name="content" class="form-control"  rows="5" placeholder="글 내 용"></textarea></div>'
		+'<button type="submit" id="writeSubmit" class="btn btn-primary btn-lg btn-block">전 송</button>'
		+'</form>';
	
	this.articleAllTable = 
/*		<style>
	table th{background: yellow;text-align: center;}
</style>*/
'<div class="container">\
<span class="glyphicon glyphicon-pencil" id="writeBtn" style="cursor:pointer; float: right;margin : 0 50px 30px 0">글쓰기</span>\
<table class="table table-condensed table-bordered table-striped" >\
	<c:if test="${data.totalPages > 0 }">\
	<tr>\
		<td colspan="5">\
			${data.startRow} - ${data.endRow}\
			[${data.pageNO}/${data.totalArticle}]\
		</td>\
	</tr>\
	</c:if>\
	<tr>\
		<th>글 번호</th>\
		<th>제목</th>\
		<th>작성자</th>\
		<th>작성일</th>\
		<th>조회수</th>\
	</tr>\
	<c:choose>\
	<c:when test="${data.totalArticle==0}">\
	<tr>\
		<td colspan="5" style="text-align: center;">\
			게시글이 없습니다.\
		</td>\
	</tr>\
		\
	</c:when>\
	<c:otherwise>\
	<c:forEach var="article" items="${list}">\
	<tr>\
		<td>${article.articleId}</td>\
		<td>\
			<c:if test="${article.level}>0">\
			<c:forEach begin="1" end="${article.level}">-</c:forEach>&gt;\
			</c:if>\
			<a class="searchId" href="${context}/article/search/${article.articleId}">${article.title}</a>\
		</td>\
		<td>${article.writerName}</td>\
		<td>${article.postingDate}</td>\
		<td>${article.readCount}</td>\
	</tr>\
	</c:forEach>\
		</c:otherwise>\
	</c:choose>\
	</table>\
	<nav>\
	<ul class="pagination" style="margin-left: 40%">\
		<c:if test="${data.startPage -data.pageSize gt 0}">\
			<li class="disabled">\
      <a href="${context}/article/page/${data.startPage-data.pageSize}" aria-label="Previous">\
        <span aria-hidden="true">&laquo;</span>\
      </a>\
    </li>\
		</c:if>\
		\
		<c:forEach begin="${data.startPage}" end="${data.endPage}" step="1" varStatus="i">\
			<c:choose>\
				<c:when test="${i.index == data.pageNO}">\
					 <li class="active"><span>${i.index}<span class="sr-only">(current)</span></span></li>\
				</c:when>\
				<c:otherwise>\
					<li><span><a href="${context}/article/page/${page}">${i.index}</a></span></li>\
				</c:otherwise>\
				\
			</c:choose>\
		</c:forEach>\
		<c:if test="${data.startPage -data.pageSize gt 0}">\
			<li class="disabled"><a href="${context}/article/page/${data.startPage+data.pageSize}" aria-label="Next">\
       \
        <span aria-hidden="true">&raquo;</span>\
      </a> </li>\
		</c:if>\
 </ul>\
	</nav>';
	//===
'\</div>';
}

Article.prototype.myArticle = function(context) {
		alert('내가 쓴 글 게시판 목록 진입');
	}
Article.prototype.articleAll = function(context) {
	$.getJSON(context+'/article/article_home',function(data) {
		var totalPages = data.command.totalPages;
		var startRow = data.command.startRow;
		var endRow = data.command.endRow;
		var pageNo = data.command.pageNo;
		var totalArticle = data.command.totalArticle;
		var startPage = data.command.startPage;
		var endPage = data.command.endPage;
		var pageSize = data.command.pageSize;
		var groupSize = data.command.groupSize; // 임시값
		alert(totalArticle);
		
		var articleAllTable = 
			'		<style>\
				table th{background: yellow;text-align: center;}\
			</style>\
			<div class="container">\
			<span class="glyphicon glyphicon-pencil" id="writeBtn" style="cursor:pointer; float: right;margin : 0 50px 30px 0">글쓰기</span>\
			<table class="table table-condensed table-bordered table-striped" >';
			if(totalPages > 0){	
			
				articleAllTable +='<tr>\
					<td colspan="5"> 총게시글\
						['+(totalArticle)+']\
					</td>\
				</tr>';
			}
				articleAllTable +='<tr>\
					<th>글 번호</th>\
					<th>제목</th>\
					<th>작성자</th>\
					<th>작성일</th>\
					<th>조회수</th>\
				</tr>';
			if (totalArticle==0) {
				articleAllTable += '<tr>\
				<td colspan="5" style="text-align: center;">\
					게시글이 없습니다.\
				</td>\
			</tr>';
			} else {
				$.each(data.article, function(index,article) {
					articleAllTable+=
						'<tr>\
							<td>'+article.articleId+'</td>\
							<td>\
							<a class="searchId" href="'+context+'/article/search/'+article.articleId+'">'+article.title+'</a>\
							</td>\
							<td>'+article.writerName+'</td>\
							<td>'+article.postingDate+'</td>\
							<td>'+article.readCount+'</td>\
						</tr>';
						
				});
			}
			
					
			articleAllTable+='</table>';
			
			
			
			var pagination = '<tr>' + '<td colspan="5" style="text-align: center;">'
				+ '<nav><ul class="pagination" style="margin-left: 40%">';
				
			/*if (startPage != 1) {
				pagination += '<a href="'+context+'/article/list/1">\
					<img src = "left.png"></a>'
			}*/	
			if (startPage - pageSize > 0) {
					pagination += '<li class="disabled">\
				      <a href="'+context+'/article/article_home?pageNo='+startPage-groupSize+'" aria-label="Previous">\
				        <span aria-hidden="true">&laquo;</span>\
				      </a>\
				    </li>';
				}
			for (var i = startPage; i <= endPage; i++) {
				if (i == pageNo) {
					pagination += '<li class="active"><span>'+i+'<span class="sr-only"></span></span></li>';
				} else {
					pagination += '<li><span><a href="'+context+'/article/article_home?pageNo='+i+'">'+i+'</a></span></li>'; 
				}
			}
			if (totalPages - endPage > 0) {
				pagination += '<a href="'+context+'/article/article_home?pageNo='+(startPage+pageSize)+'" aria-label="Next"></a>';
			}
			 '</ul>\
				</nav>';
				articleAllTable +=pagination;
				articleAllTable +='<br/>';
				var searchOption = 
					'<div style="float:right;margin:0 50px 0 0">\
						<form>\
							<select name="keyField" id="keyField">\
								<option value="title" selected="selected">제목</option>\
								<option value="name" >이름</option>\
							</select>\
							<input type="text" name="keyword" id="keyword" />\
							<input type="submit" value="검색" id="searchBtn"/>\
						</form>\
					</div>';
			articleAllTable += searchOption;
			+'\
			</div>';
		$('#content').html(articleAllTable);
	});
		
		
	}
Article.prototype.writeForm = function() {
		Article.writeForm;
		$('.container').html(writeForm);
		$('#writeSubmit').click(function() {
			$('form').attr('method','post').attr('action',article.getContext()+'/article/write').submit();
		});
			
			
	}
Article.prototype.update = function() {
		$.ajax({
			url : '',
			data : {},
			async : true,
			dataType : 'json',
			success : function(data) {
				var searchResult = '<form>'
					+'<div class="form-group">'
					+'<label for="exampleInputEmail1">글번호</label>'
					+'<input type="text" class="form-control" id="articleId" name="articleId" value="'+data.article.articleId+'" readonly>'
					+'</div>'
					+'<div class="form-group">'
					+'<label for="exampleInputEmail1">제목</label>'
					+'<input type="text" class="form-control" id="title" name="title" value="'+data.article.title+'" >'
					+'</div>'
					+'<div class="form-group">'
					+'<label for="exampleInputPassword1">작성자</label>'
					+'<input type="text" class="form-control" id="writerName" name="writerName" value="'+data.article.writerName+'" readonly></div>'
					+'<div class="form-group">'
					+'<label for="exampleInputFile">비밀번호</label>'
					+'<input type="password" id="password" class="form-control" name="password" value="'+data.article.password+'"></div>'
					+'<div class="form-group">'
					+'<label for="exampleInputFile">글내용</label>'
					+'<textarea id="content" name="content" class="form-control"  rows="5" >'+data.article.content+'</textarea></div>'
					+'<button type="submit" id="updateSubmit" class="btn col-xs-6 btn-primary btn-lg" >수 정</button>'
					+'<button type="submit" id="deleteSubmit" class="btn col-xs-6 btn-danger btn-lg" >삭 제</button>'
					+'</form>';
				$('.container').html(searchResult);
			/*	$("textarea#content").text(data.article.content);*/
				$('#updateSubmit').click(function(e) {
					e.preventDefault(); /*기존에 submit 을 무력화 시켜라*/
					$.ajax(article.getContext()+'/article/update',{
						data : {
							articleId : $('#articleId').val(),
							title : $('#title').val(),
							writerName : $('#writerName').val(),
							password : $('#password').val(),
							content : $('#content').val()
						},
						type : 'post',
						success : function(data) {
							article.detail(article.getContext()+"/article/search/"+data.id);
						},
						error : function(xhr,status,msg) {
							alert('에러발생상태 :'+status+',내용 : '+msg);
						}
							
					});
				});
				$('#deleteSubmit').click(function(e) {
					e.preventDefault();
					$.ajax(article.getContext()+'/article/delete',{
						data : {articleId : $('#articleId').val()},
						success : function(data) {
							alert(data.message);
							location.href = article.getContext()+'/article/list';
						},
						error : function(xhr,status,msg) {
							alert('에러발생상태 :'+status+',내용 : '+msg);
						}
					});
				});
			},
			error : function(xhr,status,msg) {
				alert('에러발생상태 :'+status+',내용 : '+msg);
			}
		});
	}
Article.prototype.detail = function(url) {
		$.ajax({
			url : url,
			data : {},
			async : true,
			dataType : 'json',
			success : function(data) {
				var searchResult = '<form>'
					+'<div class="form-group">'
					+'<label for="exampleInputEmail1">글번호</label>'
					+'<input type="text" class="form-control" id="articleId" name="articleId" value="'+data.article.articleId+'" readonly>'
					+'</div>'
					+'<div class="form-group">'
					+'<label for="exampleInputEmail1">제목</label>'
					+'<input type="text" class="form-control" id="title" name="title" value="'+data.article.title+'" >'
					+'</div>'
					+'<div class="form-group">'
					+'<label for="exampleInputPassword1">작성자</label>'
					+'<input type="text" class="form-control" id="writerName" name="writerName" value="'+data.article.writerName+'" readonly></div>'
					+'<div class="form-group">'
					+'<label for="exampleInputFile">비밀번호</label>'
					+'<input type="password" id="password" class="form-control" name="password" value="'+data.article.password+'"></div>'
					+'<div class="form-group">'
					+'<label for="exampleInputFile">글내용</label>'
					+'<textarea id="content" name="content" class="form-control"  rows="5" >'+data.article.content+'</textarea></div>'
					+'<button type="submit" id="updateForm" class="btn col-xs-6 btn-primary btn-lg" >수 정</button>'
					+'<button type="submit" id="replySubmit" class="btn col-xs-6 btn-danger btn-lg" >댓 글 감 추 기</button>'
					+'</form>';
				searchResult+=article.replyForm;
				$('.container').html(searchResult);
				$('#updateForm').click(function() {
					
				});
				$('#replySubmit').click(function() {
					article.reply();
				});
			},
			error : function(xhr,status,msg) {
				alert('에러발생상태 :'+status+',내용 : '+msg);
			}
		});
	}