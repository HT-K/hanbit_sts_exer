/**
 * 게시판
 */
var article = { // 객체 생성
	writeForm : function(context) { // article 객체에 하나의 메소드(writeForm())라고 생각하면 된다, list.jsp에서 ${context} 즉 컨트롤러에 접근하는 URL을 매개변수로 받아온다.
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
		
		$('#writeSubmit').click(function() {			
			$('form').attr('action',context+"/article/write").attr('method','post').submit();
		});
	}
/*,
	
	detail : function(context) {
		// ajax 시작!, searchBtn을 누름과 동시에 데이터도 날아가야한다!
		$.ajax({
			url : context + '/article/search/',
			data : {
				keyField : $('select[name=keyField] option:selected').val(), // 맵이라고 생각하자 (왼쪽이 키 값이고 오른쪽이 벨류 값이다. , 오른쪽 keyField는 위 selet 태그에서 가져온 값을 의미한다.)
				keyword : $('#keyword').val() // 키워드 텍스트필드에 입력한 값을 받아온다.
			},
			async : true, // 비동기라는 뜻
			dataType : 'json',
			success : function(data) { // 콜백 함수, 성공하면 이곳으로 와서 아래 form을 화면에 띄워준다
				var writeForm = '<form>'
						+'<div class="form-group">'
						+'<label for="exampleInputEmail1">제목</label>'
						+'<input type="text" class="form-control" id="title" name="title" placeholder="제 목" value="'data.title+'" readonly>' // value 값은 ''싱글 커터를 살리기 위해 ""더블커터 사이에 싱글커터안에 넣어준다!
						+'</div>'
						+'<div class="form-group">'
						+'<label for="exampleInputPassword1">작성자</label>'
						+'<input type="text" class="form-control" id="writerName" name="writerName" placeholder="작 성 자" value="'data.writerName+'"></div>'
						+'<div class="form-group">'
						+'<label for="exampleInputFile">글암호</label>'
						+'<input type="password" id="password" class="form-control" name="password" placeholder="비 밀 번 호" value="'data.password+'"></div>'
						+'<div class="form-group">'
						+'<label for="exampleInputFile">글내용</label>'
						+'<textarea id="content" name="content" class="form-control" rows="5" placeholder="글 내 용" value="'data.content+'"></textarea></div>'
						+'<button type="submit" id="writeSubmit" class="btn btn-primary btn-lg btn-block">전송</button>'
						+'</form>';
						$('.container').html(writeForm); // container클래스가 감싸고 있는 곳의 내용을 지우고 그 위에 writeForm을 덮어쓰겠다는 뜻이다!
			},
			erroe : function(xhr, status, msg) { // 실패하면 이곳으로, 왼쪽 매개변수는 정해져 있다.
				alert('에러 발생 상태 : '+status+' 내용 : '+msg);
			}
		});
	}*/
};
