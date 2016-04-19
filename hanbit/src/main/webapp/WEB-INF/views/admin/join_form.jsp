<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="join">
		<div class="joinTop">
			<h2 class="text-center">회원가입</h2>
		</div>
		<div class="joinCenter row">
			<form>
				<fieldset class="joinField">
					<div class="form-group">
						<label for="input_user" class="col-sm-4 control-label">회원등급</label>
					 	<div class="col-sm-4">
							<input type="radio" class="form-control" id="cate" name="cate" value="1"/> 학생
							<input type="radio" class="form-control" id="cate" name="cate" value="2"/> 교수
							<input type="radio" class="form-control" id="cate" name="cate" value="3"/> 관리자
						</div>
					</div>
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					 	<div class="col-sm-4">
							<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw_check" class="col-sm-4 control-label">비밀번호 확인</label>
						<div class="col-sm-4">
							<input type="password" class="form-control" name="passwordCheck" id="passwordCheck" placeholder="비밀번호를 확인하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
							<input type="radio" name="addr" id="addr" value="서울" checked /> 서울
							<input type="radio" name="addr" id="addr" value="인천" checked /> 인천
							<input type="radio" name="addr" id="addr" value="경기" checked /> 경기
							<input type="radio" name="addr" id="addr" value="부산" checked /> 부산
							<input type="radio" name="addr" id="addr" value="대전" checked /> 대전
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="birth" name="birth" placeholder="생년월일을 입력하세요"/>
						</div>
					</div>
					<div class="input_button text-center">
						<button id="joinBtn">회원가입</button>
						<button id="resetBtn">취소</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$form = $('form');
		$form.addClass('form-horizontal');
		
		$('#joinBtn').addClass('btn btn-primary').click(function() { // 회원가입 버튼 클릭 시 포스트방식으로 전송
			$form.attr('action','${context}/admin/join').attr('method','post').submit();
		});
		$('#resetBtn').addClass('btn btn-primary').click(function() { // 취소 버튼 클릭 시
			$form.reset();
		});
	});
</script>