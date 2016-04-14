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
						+'<label for="exampleInputEmail1">제목</label>'
						+'<input type="text" class="form-control" id="title" name="title" placeholder="제 목" value="' + data.article.title + '">' // value 값은 ''싱글 커터를 살리기 위해 ""더블커터 사이에 싱글커터안에 넣어준다!
						+'</div>'
						+'<div class="form-group">'
						+'<label for="exampleInputPassword1">작성자</label>'
						+'<input type="text" class="form-control" id="writerName" name="writerName" value="' + data.article.writerName + '" placeholder="작 성 자" readonly></div>'
						+'<div class="form-group">'
						+'<label for="exampleInputFile">글암호</label>'
						+'<input type="password" id="password" class="form-control" name="password" value="' + data.article.password + '" placeholder="비 밀 번 호" ></div>'
						+'<div class="form-group">'
						+'<label for="exampleInputFile">글내용</label>'
						+'<textarea id="content" name="content" class="form-control" rows="5" placeholder="글 내 용"  >' + data.article.content + '</textarea></div>'
						+'<button type="submit" id="updateSubmit" class="btn btn-primary btn-lg btn-block">수 정</button>'
						+'</form>';
						$('.container').html(detailForm);
						
						//위에 textarea에 값을 넣을 때 <textarea></textarea> 사이에 넣어도 상관없고 아래와 같이해도 상관없다.
						//$("textarea#content").text(data.article.content);
						
						$('#updateSubmit').click(function() {
							$.ajax(article.getContext() + '/article/update',{ // 이렇게 .ajax 함수의 파라미터로 url을 넘겨도되고 아래와 같이 써도 된다.
								//url : article.getContext() + '/article/update', 
								data : {
									title : $('#title').val(),
									password : $('#password').val(),
									content : $('#content').text()
								},
								type : 'post', // 이곳에 type을 쓰지 않으면 디폴트로 get이 된다.
								async : true, // 당연히 true여야한다. 생략가능하다
								dataType : 'json', // 생략이 가능하다, 왜냐하면 view-context.xml에서 설정해놨다.
								success : function() {
									
								},
								error : function(xhr, status, msg) { // 실패하면 이곳으로, 왼쪽 매개변수는 정해져 있다.
									alert('에러 발생 상태 : '+status+' 내용 : '+msg);
								}
							});
						});
			},
			error : function(xhr, status, msg) { // 실패하면 이곳으로, 왼쪽 매개변수는 정해져 있다.
				alert('에러 발생 상태 : '+status+' 내용 : '+msg);
			}
		});
	},
};
