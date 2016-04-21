<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="detail">
		<div class="joinTop">
			<h2 class="text-center">수정정보</h2>
		</div>
			
		<div class="joinCenter row">
			<form>
				<fieldset class="joinField">
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">프로필 이미지 등록</label>
					 	<div class="col-sm-2">
							<img src="${img}/member/${member.profileImg}" alt="" style="width:200px;height:230px"/>
						</div>
					 	<div class="col-sm-2">
							<input type="file" id="profile_img" name="profile_img" />
						</div>
					</div>
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					 	<div class="col-sm-4">
							<input type="password" class="form-control" id="password" name="password" value="${member.password}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="name" name="name" value="${member.name}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="addr" name="addr" value="${member.addr}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="birth" name="birth" value="${member.birth}" readonly="readonly"/>
						</div>
					</div>
					<div class="input_button text-center">
						<button id="updateBtn">수정</button>
						<button id="cancleBtn">취소</button>
					</div>
						
				</fieldset>
			</form>
		</div>
	</div>
	<script src="${js}/member.js"></script>
	<script type="text/javascript">
		$(function() {
			$form = $('form'); // 위에 form태그는 하나다 그냥 변수로 처리해버림
			// 컨트롤러에 form내용을 보내는 방식 (ajax 적용 전!)
			//$form.addClass('form-horizontal').attr('method','post').attr('action','${context}/member/update');
			$form.addClass('form-horizontal');
			$('#updateBtn').addClass('btn btn-primary').click(function(e) {
				e.preventDefault(); // .click 다음에 무조건 써주자
				//$form.submit();
				member.setContext('${context}'); // member.js 에 컨텍스트 경로 보내주기
				member.update(); // member.js 의 함수 호출
			});
			$('#cancleBtn').addClass('btn btn-primary').click(function() {
				$form.reset();
			});
		});
	</script>