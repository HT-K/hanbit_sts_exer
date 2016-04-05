<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div id="join">
		<div class="joinTop">
			<h2 class="text-center">회원가입</h2>
		</div>
		<div class="joinCenter row">
			<form>
				<fieldset class="joinField">
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
							<input type="text" class="form-control" id="addr" name="addr" placeholder="주소를 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="birth" name="birth" placeholder="생년월일을 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">수강과목</label>
					 	<div class="col-sm-4">
							<input type="checkbox" class="form-control" id="subject" name="Java" /> Java
							<input type="checkbox" class="form-control" id="subject" name="Jsp" /> Jsp
							<input type="checkbox" class="form-control" id="subject" name="Sql" /> Sql
							<input type="checkbox" class="form-control" id="subject" name="Spring" /> Spring
							<input type="checkbox" class="form-control" id="subject" name="파이썬" /> 파이썬
							<input type="checkbox" class="form-control" id="subject" name="노드JS" /> 노드JS
							<input type="checkbox" class="form-control" id="subject" name="안드로이드" /> 안드로이드
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">전 공</label>
					 	<select name="major" id="major">
					 		<option value="computer">컴퓨터공학</option>
					 		<option value="info">정보통신</option>
					 		<option value="security">정보보안</option>
					 	</select>
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
		$form.addClass('form-horizontal').attr('method','post');
		
		$('#joinBtn').addClass('btn btn-primary').click(function() { // 회원가입 버튼 클릭 시 포스트방식으로 전송
			$form.attr('action','${context}/member/join.do').submit();
		});
		$('#resetBtn').addClass('btn btn-primary').click(function() { // 취소 버튼 클릭 시
			$form.reset();
		});
	});
</script>
</html>