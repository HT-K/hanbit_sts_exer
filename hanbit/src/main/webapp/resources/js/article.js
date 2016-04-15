/**
 * 게시판
 */
var article = { // 객체 생성
	context : '', // context가 key고 (:) 오른쪽이 value라고 생각하면 된다. 스크립트의 모든 것은 이 형태라고 보면 된다.
	setContext : function(context) { // 외부에서 달러{context} 값을 받아와서 이 article 객체의 context 변수에 set한다! 이렇게하면 이 js 파일안에서 사용이 가능하다!
		this.context = context;
	},
	getContext : function() { // 이 article객체의 context 값을 리턴해준다.
		return this.context;
	},
	writeForm : function() { // article 객체에 하나의 메소드(writeForm())라고 생각하면 된다, list.jsp에서 ${context} 즉 컨트롤러에 접근하는 URL을 매개변수로 받아온다.
		var writeForm = '<form>'
		+'<div class="form-group">'
		+'<label for="title">제목</label>'
		+'<input type="text" class="form-control" id="title" name="title" placeholder="제 목">'
		+'</div>'
		+'<div class="form-group">'
		+'<label for="writerName">작성자</label>'
		+'<input type="text" class="form-control" id="writerName" name="writerName" placeholder="작 성 자"></div>'
		+'<div class="form-group">'
		+'<label for="password">글암호</label>'
		+'<input type="password" id="password" class="form-control" name="password" placeholder="비 밀 번 호"></div>'
		+'<div class="form-group">'
		+'<label for="content">글내용</label>'
		+'<textarea id="content" name="content" class="form-control" rows="5" placeholder="글 내 용"></textarea></div>'
		+'<button type="submit" id="writeSubmit" class="btn btn-primary btn-lg btn-block">전송</button>'
		+'</form>';
		$('.container').html(writeForm); // container클래스가 감싸고 있는 곳의 내용을 지우고 그 위에 writeForm을 덮어쓰겠다는 뜻이다!
		
		// 위에서 set한 context 값을 호출해서 URL을 만들어 컨트롤러를 호출한다.
		$('#writeSubmit').click(function() {			
			$('form').attr('action',article.getContext()+"/article/write").attr('method','post').submit();
		});
	},
	
	detail : function(url) {
		// 제목을 클릭하면 이 함수가 호출되고 controller에서 model에 들어있는 값을 받아온다.
		alert("detail 체크");
		$.ajax({ // $.ajax({}) , 이런식으로 객체{}를 매개변수로 써야한다.
			url : url, // 호출할 URL주소
			data : {}, // 데이터를 가지고 올 객체라고 생각하면 된다. (위에 적힌 url(컨트롤러)로 가서 model에 담긴 객체를 가져올 변수라고 생각하면된다.)
			async : true, // 비동기라는 뜻
			dataType : 'json',
			success : function(data) { // 콜백 함수, 성공하면 이곳으로 model에 담긴 값(데이터베이스에서 가져온 ArticleDTO 객체)이 'data'에 담겨있게 된다. 우리는 이 'data'로 컨트롤러에서 가져온 값을 사용할 수 있다. 
				alert("url : " + url);
				alert('서버를 다녀온 AJAX 결과 : '+ data.article.title);
				var detailForm = '<form>'
					+'<div class="form-group">'
					+'<label for="articleId">게시글 번호</label>'
					+'<input type="text" class="form-control" id="articleId" name="articleId" placeholder="글 번호" value="' + data.article.articleId + '" readonly>'
					+'</div>'
					+'<div class="form-group">'
					+'<label for="title">제목</label>'
					+'<input type="text" class="form-control" id="title" name="title" placeholder="제 목" value="' + data.article.title + '">' // value 값은 ''싱글 커터를 살리기 위해 ""더블커터 사이에 싱글커터안에 넣어준다!
					+'</div>'
					+'<div class="form-group">'
					+'<label for="writerName">작성자</label>'
					+'<input type="text" class="form-control" id="writerName" name="writerName" value="' + data.article.writerName + '" placeholder="작 성 자" readonly></div>'
					+'<div class="form-group">'
					+'<label for="password">글암호</label>'
					+'<input type="password" id="password" class="form-control" name="password" value="' + data.article.password + '" placeholder="비 밀 번 호" ></div>'
					+'<div class="form-group">'
					+'<label for="content">글내용</label>'
					+'<textarea id="content" name="content" class="form-control" rows="5" placeholder="글 내 용"  >' + data.article.content + '</textarea></div>'
					+'<button type="submit" id="updateBtn" name="updateBtn" class="btn col-xs-4 btn-primary btn-lg">수 정</button>'   
					+'<button type="submit" id="deleteBtn" name="deleteBtn" class="btn col-xs-4 btn-danger btn-lg">삭 제</button>'
					+'<button type="submit" id="replyBtn" name="replyBtn" class="btn col-xs-4 btn-info btn-lg">댓글창 감추기</button>'
					+'</form>'
					+'<form id="replyForm">'
					+'<div class="form-group">'
					+'<label for="exampleInputFile">댓 글</label>'
					+'<form><textarea name="reply_content" id="reply_content" class="form-control" style="height : 50px"></textarea>'
					+'</div>'
					+'<button type="submit" id="replySuccess" class="btn col-xs-6 btn-success btn-lg" >확 인</button>'
					+'<button type="reset" id="replyCancle" class="btn col-xs-6 btn-warning btn-lg" >취 소</button>'
					+'</form>';
				$('.container').html(detailForm);
						
						//위에 textarea에 값을 넣을 때 <textarea></textarea> 사이에 넣어도 상관없고 아래와 같이해도 상관없다.
						//$("textarea#content").text(data.article.content);
						
				$('#updateBtn').click(function(e) {
					e.preventDefault(); // 기존의 submit를 무력화 시켜라!!
					alert(article.getContext() + '/article/update');
					$.ajax(article.getContext() + '/article/update',{ // 이렇게 .ajax 함수의 파라미터로 url을 넘겨도되고 아래와 같이 써도 된다.
						//url : article.getContext() + '/article/update', 
						data : { // 위 URL로 호출되는 컨트롤러에 보낼 데이터들이다.
							articleId : $('#articleId').val(),
							title : $('#title').val(),
							writerName : $('#writerName').val(),
							password : $('#password').val(),
							content : $('#content').val()
						},
						type : 'post', // 이곳에 type을 쓰지 않으면 디폴트로 get이 된다.
						async : true, // 당연히 true여야한다. 생략가능하다
						dataType : 'json', // 생략이 가능하다, 왜냐하면 view-context.xml에서 설정해놨다.
						success : function(data) {
							alert("업데이트 성공!!");
							article.detail(article.getContext() + "/article/search/" + data.id); // 업데이트 성공 후, 해당 글 id 값 포함한 URL을 article.detail로 보내면 업데이트 된 내용이 스므스하게 화면에 바로 보이게 된다!
						},
						error : function(xhr, status, msg) { // 실패하면 이곳으로, 왼쪽 매개변수는 정해져 있다.
							alert('에러 발생 상태 : '+status+' 내용 : '+msg);
						}
					});
				});// update click end
				
				$('#deleteBtn').click(function(e) {
					alert("삭제버튼 클릭 체크");
					e.preventDefault();
					$.ajax(article.getContext() + '/article/delete',{ // controller에서 삭제를 담당할 메소드를 호출할 URL
						data : {
							articleId : $('#articleId').val() // type을 지정하지 않았으므로 get방식으로 보내진다. 우리 눈에는 보이지 않지만 URL이 context+'article/delete?articleId=$('#articleId').val() 이렇게 보내지게 된다.
						},
						success : function(data) {
							alert(data.message);
							location.href = article.getContext() + '/article/list';
						},
						error : function(xhr, status, msg) { // 실패하면 이곳으로, 매개변수는 저렇게 정해져 있다.
							alert('에러 발생 상태 : '+status+' 내용 : '+msg);
						}
					});
				}); // delete click End
				
				$('#replyBtn').click(function(e) {
					alert("댓글달기 버튼 클릭 체크");
					e.preventDefault();
					$("#replyForm").remove();
				}); // reply click End
				
				$('#replySuccess').click(function(e) { // 댓글 완료 버튼 클릭 시
					alert("댓글완료 버튼 클릭 체크");
					$.ajax({
						url : article.getContext() + '/article/reply',
						data : {
							articleId : $('#articleId').val(),
							reply_content : $('#reply_content').val()
						},
						success : function(data) {
							alert("댓글들 들고 왔나 체크");
							var replyRes = '<div class="form-group">'
								+'<input type="text" class="form-control" id="replyRes" name="replyRes" value="' + data.reply.reply_content + '" placeholder="댓글내용">'
								+'</div>';
								$('.container').append(replyRes);
						},
						error : function(xhr, status, msg) { // 실패하면 이곳으로, 매개변수는 저렇게 정해져 있다.
							alert('에러 발생 상태 : '+status+' 내용 : '+msg);
						}
					});
				}); // replySuccess click End
			},
			error : function(xhr, status, msg) { // 실패하면 이곳으로, 왼쪽 매개변수는 정해져 있다.
				alert('에러 발생 상태 : '+status+' 내용 : '+msg);
			}
		});
	}
};
