/**
 * 
 */

// 디폴트 생성자
function Member() {
	Member.prototype.joinForm = function(context) { // 함수 표현식
		var joinForm = 
			'<div id="join">\
				<div class="joinTop">\
					<h2 class="text-center">회원가입</h2>\
				</div>\
				<div class="joinCenter row">\
					<form class="form-horizontal">\
						<fieldset class="joinField">\
							<div class="form-group">\
								<label for="input_user" class="col-sm-4 control-label">회원등급</label>\
				 				<div class="col-sm-4">\
									<input type="radio" class="form-control" id="cate" name="cate" value="1"/> 학생\
									<input type="radio" class="form-control" id="cate" name="cate" value="2"/> 교수\
									<input type="radio" class="form-control" id="cate" name="cate" value="3"/> 관리자\
								</div>\
							</div>\
						<div class="form-group">\
				 			<label for="input_id" class="col-sm-4 control-label">아이디</label>\
				 			<div class="col-sm-4">\
								<input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요"/>\
							</div>\
						</div>\
						<div class="form-group">\
							<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>\
				 			<div class="col-sm-4">\
								<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요"/>\
							</div>\
						</div>\
						<div class="form-group">\
							<label for="input_pw_check" class="col-sm-4 control-label">비밀번호 확인</label>\
							<div class="col-sm-4">\
								<input type="password" class="form-control" name="passwordCheck" id="passwordCheck" placeholder="비밀번호를 확인하세요"/>\
							</div>\
						</div>\
						<div class="form-group">\
							<label for="input_name" class="col-sm-4 control-label">이름</label>\
				 			<div class="col-sm-4">\
								<input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요"/>\
							</div>\
						</div>\
						<div class="form-group">\
							<label for="input_name" class="col-sm-4 control-label">주소</label>\
				 			<div class="col-sm-4">\
								<input type="radio" name="addr" id="addr" value="서울" checked /> 서울\
								<input type="radio" name="addr" id="addr" value="인천" checked /> 인천\
								<input type="radio" name="addr" id="addr" value="경기" checked /> 경기\
								<input type="radio" name="addr" id="addr" value="부산" checked /> 부산\
								<input type="radio" name="addr" id="addr" value="대전" checked /> 대전\
							</div>\
						</div>\
						<div class="form-group">\
							<label for="input_name" class="col-sm-4 control-label">생년월일</label>\
				 			<div class="col-sm-4">\
								<input type="text" class="form-control" id="birth" name="birth" placeholder="생년월일을 입력하세요"/>\
							</div>\
						</div>\
						<div class="form-group">\
							<label for="input_name" class="col-sm-4 control-label">수강과목</label>\
				 			<div class="col-sm-4">\
								<input type="checkbox" class="form-control" id="subject" name="Java" /> Java\
								<input type="checkbox" class="form-control" id="subject" name="Jsp" /> Jsp\
								<input type="checkbox" class="form-control" id="subject" name="Sql" /> Sql\
								<input type="checkbox" class="form-control" id="subject" name="Spring" /> Spring\
								<input type="checkbox" class="form-control" id="subject" name="파이썬" /> 파이썬\
								<input type="checkbox" class="form-control" id="subject" name="노드JS" /> 노드JS\
								<input type="checkbox" class="form-control" id="subject" name="안드로이드" /> 안드로이드\
							</div>\
						</div>\
						<div class="form-group">\
							<label for="input_name" class="col-sm-4 control-label">전 공</label>\
				 			<select name="major" id="major">\
				 				<option value="computer">컴퓨터공학</option>\
				 				<option value="info">정보통신</option>\
				 				<option value="security">정보보안</option>\
				 			</select>\
						</div>\
						<div class="input_button text-center">\
							<button class="btn btn-primary" id="joinBtn">회원가입</button>\
							<button class="btn btn-primary" id="resetBtn">취소</button>\
						</div>\
					</fieldset>\
				</form>\
			</div>\
		</div>';
		$('#content').html(joinForm);
		
		$('#joinBtn').click(function(e) {
			e.preventDefault();
			alert("왔나 체크");
			var member = {
				"id" : $('#id').val(),	
				"password" : $('#password').val(),	
				"name" : $('#name').val(),	
				"addr" : $('#addr').val(),	
				"birth" : $('#birth').val(),
				"major" : $('#major').val(),	
				"cate" : $('#cate').val()
			};
			$.ajax({
				url : context+'/member/join',
				data : JSON.stringify(member), // 컨트롤러에서 @RequestBody로 받아야한다.
				dataType : 'json',
				type : 'post',
				contentType : 'application/json',
				mimeType : 'application/json',
				success : function(data) {
					if (data != null) {
						alert(data.name+ '님이 회원으로 등록되셨습니다.');
						location.href = context+'/member/login_form';
					}
				},
				error : function(xhr, status, msg) {
					alert("회원가입시 에러발생 : " + msg);
				}
			});
		});
	}
}